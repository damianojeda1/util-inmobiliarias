-------------------------------Datos De Las Pesonas-----------------------------
INSERT INTO inmobiliaria.persona(id_persona, razonsocial_persona, tipodoc_persona, nrodoc_persona, 
            mail_persona, telefono_persona, direccion_persona, tipo_persona , estado_persona, id_ciudad_persona)

    VALUES (1,'Titular 1', 'DNI', '', '', '', 
            '', 'Titular', true, 26317),
          (2,'Titular 2', 'DNI', '', '', '', 
            '', 'Titular', true, 26317),
           (3,'Damian Ojeda', 'CUIT', '20355437117', 'damianojeda1@gmail.com', '3584848511', 
            '', 'Administrador', true, 26317);
SELECT setval('inmobiliaria.persona_id_persona_seq', 3, true);
---------------------------------------------------------------------------------
INSERT INTO inmobiliaria.usuario(nombre_usuario, clave_usuario, recordar_usuario, 
            estado_usuario, id_persona_usuario)

    VALUES ('Titular 1', '1234', false, true, 1),
           ('Titular 2', '1234', false, true, 2),
           ('Admin', '11155636', false, true, 3);
SELECT setval('inmobiliaria.usuario_id_usuario_seq', 3, true);
