@echo off
setlocal DisableDelayedExpansion
set "UTIL_TREE_SCRIPT=%~f0"
powershell.exe -NoLogo -NoProfile -NonInteractive -Command "$raw = [IO.File]::ReadAllText($env:UTIL_TREE_SCRIPT); $parts = $raw -csplit '(?m)^# POWERSHELL\r?$', 2; if ($parts.Length -ne 2) { exit 1 }; try { & ([scriptblock]::Create($parts[1])) } catch { [Console]::Error.WriteLine($_.Exception.Message); exit 1 }"
if errorlevel 1 (
    echo No se pudo generar README_ARBOL.md.
    pause
    exit /b 1
)
echo Generado: README_ARBOL.md
exit /b 0
# POWERSHELL
$ErrorActionPreference = 'Stop'
$root = [IO.Path]::GetDirectoryName($env:UTIL_TREE_SCRIPT)
$output = [IO.Path]::Combine($root, 'README_ARBOL.md')
$skipDirs = @('.git', '.svn', '.idea', '.gradle', 'node_modules', 'target', 'dist', 'build', 'out', 'coverage')
$lines = [Collections.Generic.List[string]]::new()
$fence = ([string][char]96) * 3

function Add-Tree([string]$Path, [string]$Indent) {
    $entries = @(Get-ChildItem -LiteralPath $Path -Force | Where-Object {
        -not ($_.Attributes -band [IO.FileAttributes]::ReparsePoint) -and
        $_.FullName -ne $output -and $_.FullName -ne $env:UTIL_TREE_SCRIPT -and
        $_.Name -notlike '.env*' -and
        (-not $_.PSIsContainer -or $_.Name -notin $skipDirs)
    } | Sort-Object @{Expression = 'PSIsContainer'; Descending = $true}, Name)

    for ($i = 0; $i -lt $entries.Count; $i++) {
        $entry = $entries[$i]
        $last = $i -eq ($entries.Count - 1)
        if ($last) { $branch = '\-- '; $next = '    ' }
        else { $branch = '|-- '; $next = '|   ' }

        $name = $entry.Name
        if ($entry.PSIsContainer) { $name += '/' }
        $lines.Add($Indent + $branch + $name)
        if ($entry.PSIsContainer) { Add-Tree $entry.FullName ($Indent + $next) }
    }
}

$lines.Add('# Arbol de archivos')
$lines.Add('')
$lines.Add($fence + 'text')
$lines.Add('./')
Add-Tree $root ''
$lines.Add($fence)
[IO.File]::WriteAllLines($output, $lines.ToArray(), [Text.UTF8Encoding]::new($false))
