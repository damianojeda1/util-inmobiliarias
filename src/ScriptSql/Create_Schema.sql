-- Instalacion inicial en una base PostgreSQL ya creada.
-- No usar como migracion de una base existente.

BEGIN;

CREATE SCHEMA inmobiliaria;

SET LOCAL search_path TO inmobiliaria;

CREATE TABLE provincia ( 
  id_provincia SERIAL NOT NULL,
  nombre_provincia varchar(50) NOT NULL,
  constraint provincia_unico UNIQUE (nombre_provincia),
  constraint pk_provincia primary key (id_provincia)
);

CREATE TABLE ciudad ( 
  id_ciudad SERIAL NOT NULL,
  nombre_ciudad varchar(100) NOT NULL,
  id_provincia_ciudad int NOT NULL,
  constraint ciudad_unico UNIQUE (nombre_ciudad,id_provincia_ciudad),
  constraint fk_id_provincia_ciudad foreign key (id_provincia_ciudad) references provincia(id_provincia) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint pk_ciudad primary key (id_ciudad)
);

CREATE TABLE persona ( 
  id_persona SERIAL NOT NULL,
  razonSocial_persona varchar(100),
  tipoDoc_persona varchar(10) NOT NULL,
  nroDoc_persona varchar(20),
  mail_persona varchar(100),
  telefono_persona varchar(50),
  direccion_persona varchar(100),
  estado_persona boolean DEFAULT true,
  tipo_persona varchar(20),
  id_ciudad_persona int NOT NULL,
  constraint fk_id_ciudad_persona foreign key (id_ciudad_persona) references ciudad(id_ciudad) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint pk_persona primary key (id_persona)
);

CREATE TABLE usuario ( 
  id_usuario SERIAL NOT NULL,
  nombre_usuario varchar(50) NOT NULL,
  clave_usuario varchar(50) NOT NULL,
  recordar_usuario boolean DEFAULT false,
  estado_usuario boolean DEFAULT true,
  id_persona_usuario int NOT NULL,
  constraint usuario_unico UNIQUE (nombre_usuario),
  constraint fk_id_persona_usuario foreign key (id_persona_usuario) references persona(id_persona) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_usuario primary key (id_usuario)
);

CREATE TABLE comprobante ( 
  id_comprobante SERIAL NOT NULL,
  tipo_comprobante varchar(50) NOT NULL,
  nro_comprobante int NOT NULL,
  total_comprobante decimal(20,2) DEFAULT 0,
  fecha_comprobante date NOT NULL,
  id_cliente_comprobante int NOT NULL,
  id_vendedor_comprobante int NOT NULL,
  observacion_comprobante varchar(200),
  estado_comprobante varchar(10) DEFAULT 'Aprobado',
  constraint comprobante_unico UNIQUE (tipo_comprobante,nro_comprobante),
  constraint fk_id_cliente_comprobante foreign key (id_cliente_comprobante) references persona(id_persona) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint fk_id_vendedor_comprobante foreign key (id_vendedor_comprobante) references persona(id_persona) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint pk_comprobante primary key (id_comprobante)
);

CREATE TABLE pago ( 
  id_pago SERIAL NOT NULL,
  tipo_pago varchar(30) NOT NULL,
  fecha_pago date NOT NULL,
  monto_pago decimal(20,2) DEFAULT 0,
  id_comprobante_pago int NOT NULL,
  constraint pago_unico UNIQUE (id_comprobante_pago,fecha_pago,tipo_pago),
  constraint fk_id_comprobante_pago foreign key (id_comprobante_pago) references comprobante(id_comprobante) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_pago primary key (id_pago)
);

CREATE TABLE sector (
  id_sector SERIAL NOT NULL,
  nombre_sector varchar(30) NOT NULL,
  constraint sector_unico UNIQUE (nombre_sector),
  constraint pk_sector primary key (id_sector)  
);

CREATE TABLE inmueble ( 
  id_inmueble SERIAL NOT NULL,
  tipo_inmueble varchar(100),
  valorAlquiler_inmueble decimal(20,2) DEFAULT 0,
  valorVenta_inmueble decimal(20,2) DEFAULT 0,
  direccion_inmueble varchar(100) NOT NULL,
  observacion_inmueble varchar(1000),
  dimension_inmueble decimal(20,2) NOT NULL,
  id_sector_inmueble integer NOT NULL,
  estado_inmueble varchar(100) NOT NULL,
  gas_inmueble boolean NOT NULL,
  agua_inmueble boolean NOT NULL,
  cloaca_inmueble boolean NOT NULL,
  telefono_inmueble boolean default false,
  pavimento_inmueble boolean default false,
  luz_inmueble boolean NOT NULL,
  id_propietario_inmueble int NOT NULL,
  id_ciudad_inmueble int NOT NULL,
  montoExpensas_inmueble decimal(10,2) DEFAULT 0,
  montoMunicipal_inmueble decimal(10,2) DEFAULT 0,
  montoEMOS_inmueble decimal(10,2) DEFAULT 0,
  constraint inmueble_unico UNIQUE (direccion_inmueble),
  constraint fk_id_dueño_inmueble foreign key (id_propietario_inmueble) references persona(id_persona) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint fk_id_sector_inmueble foreign key (id_sector_inmueble) references sector(id_sector) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint fk_id_ciudad_inmueble foreign key (id_ciudad_inmueble) references ciudad(id_ciudad) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint pk_inmueble primary key (id_inmueble)
);

CREATE TABLE local (
  id_local SERIAL NOT NULL,
  expensa_local decimal(20,2) DEFAULT 0,
  cochera_local int,
  estacionamiento_local boolean,
  bano_local int,
  cocina_local boolean,
  calefaccion_local varchar(30),
  edificado_local decimal(20,2) DEFAULT 0,
  ambiente_local int,
  aire_local boolean,
  id_inmueble_local int,
  observacion_local varchar(200),
  constraint fk_id_inmueble_local foreign key (id_inmueble_local) references inmueble(id_inmueble),
  constraint pk_local primary key (id_local)
);

CREATE TABLE casa (
  id_casa SERIAL NOT NULL,
  edificado_casa decimal(20,2) DEFAULT 0,
  banos_casa int,
  ambientes_casa int,
  dormitorios_casa int,
  patio_casa boolean,
  garaje_casa int,
  asador_casa boolean,
  nropisos_casa int,
  pileta_casa boolean,
  quincho_casa boolean,
  id_inmueble_casa int,
  observacion_casa varchar(200),
  constraint fk_id_inmueble_casa foreign key (id_inmueble_casa) references inmueble(id_inmueble),
  constraint pk_casa primary key (id_casa)  
);

CREATE TABLE departamento (
  id_departamento SERIAL NOT NULL,
  edificado_departamento decimal(20,2) DEFAULT 0,
  expensa_departamento decimal(20,2),
  municipal_departamento decimal(10,2) DEFAULT 0,
  emos_departamento decimal(10,2) DEFAULT 0,
  banos_departamento int,
  ambiente_departamento int,
  balcon_departamento boolean,
  dormitorio_departamento int,
  asador_departamento boolean,
  piso_departamento int,
  dpto_departamento varchar(10),
  cochera_departamento boolean,
  id_inmueble_departamento int,
  observacion_departamento varchar(200),
  constraint fk_id_inmueble_departamento foreign key (id_inmueble_departamento) references inmueble(id_inmueble),
  constraint pk_departamento primary key (id_departamento)  
);

CREATE TABLE campo (
  id_campo SERIAL NOT NULL,
  tipo_campo varchar(100),
  galpon_campo int,
  silo_campo int,
  corral_campo int,
  alambrado_campo boolean,
  brete_campo int,
  id_inmueble_campo int,
  superficieA_campo decimal(20,2) default 0,
  superficieG_campo decimal(20,2) default 0,
  observacion_campo varchar(200),
  constraint fk_id_inmueble_campo foreign key (id_inmueble_campo) references inmueble(id_inmueble),
  constraint pk_campo primary key (id_campo)  
);

CREATE TABLE cochera (
  id_cochera SERIAL NOT NULL,
  capacidad_cochera int,
  capacidadtechada_cochera int,
  bano_cochera int,
  oficina_cochera int,
  nropisos_cochera int,
  id_inmueble_cochera int,
  observacion_cochera varchar(200),
  constraint fk_id_inmueble_cochera foreign key (id_inmueble_cochera) references inmueble(id_inmueble),
  constraint pk_cochera primary key (id_cochera)  
);

CREATE TABLE galpon (
  id_galpon SERIAL NOT NULL,
  capacidad_galpon int,
  edificado_galpon int,
  bano_galpon int,
  oficina_galpon int,
  id_inmueble_galpon int,
  observacion_galpon varchar(200),
  constraint fk_id_inmueble_galpon foreign key (id_inmueble_galpon) references inmueble(id_inmueble),
  constraint pk_galpon primary key (id_galpon)  
);

CREATE TABLE imagen (
  id_imagen SERIAL NOT NULL,
  path_imagen varchar(100) NOT NULL,
  id_inmueble_imagen int NOT NULL,
  constraint path_unico UNIQUE (path_imagen),
  constraint fk_id_inmueble_imagen foreign key (id_inmueble_imagen) references inmueble(id_inmueble) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_imagen primary key (id_imagen)  
);


CREATE TABLE contratoalquiler ( 
  id_contratoalquiler SERIAL NOT NULL,
  nro_contratoalquiler int NOT NULL,
  observacion_contratoalquiler varchar(500), 
  path_contratoalquiler varchar(200),
  estado_contratoalquiler varchar(100),
  diavencimiento_contratoalquiler int NOT NULL DEFAULT 0,
  monto_contratoalquiler decimal(20,2) DEFAULT 0,
  recargo_contratoalquiler decimal(20,2) DEFAULT 0,
  reajuste_contratoalquiler decimal(20,2) DEFAULT 0,
  tiemporeajuste_contratoalquiler int NOT NULL DEFAULT 1,
  montoactual_contratoalquiler decimal(20,2) DEFAULT 0,
  comision_contratoalquiler decimal(20,2) DEFAULT 0,
  fecha_contratoalquiler date NOT NULL,
  fin_contratoalquiler date NOT NULL,
  id_inmueble_contratoalquiler int NOT NULL,
  id_inquilino_contratoalquiler int NOT NULL,
  proximoAjuste_contratoalquiler date,
  deposito_contratoalquiler decimal(20,2),
  proximoCobro_contratoalquiler date,
  saldo_contratoalquiler float DEFAULT 0, 
  tipo_comision_contratoalquiler integer DEFAULT 1, -- 1:Porcentaje   2:Efectivo
  tipo_recargo_contratoalquiler integer DEFAULT 1, -- 1:Porcentaje   2:Efectivo
  constraint fk_id_inmueble_contratoalquiler foreign key (id_inmueble_contratoalquiler) references inmueble(id_inmueble) ON UPDATE CASCADE ON DELETE RESTRICT,
  constraint fk_id_inquilino_contratoalquiler foreign key (id_inquilino_contratoalquiler) references persona(id_persona) ON UPDATE CASCADE ON DELETE RESTRICT,  
  constraint pk_contratoalquiler primary key (id_contratoalquiler)  
);

CREATE TABLE comprobantealquiler ( 
  id_comprobanteAlquiler SERIAL NOT NULL,
  tipo_comprobanteAlquiler varchar(50) NOT NULL,
  nro_comprobanteAlquiler int NOT NULL,
  total_comprobanteAlquiler decimal(20,2) DEFAULT 0,
  fecha_comprobanteAlquiler date NOT NULL,
  id_contratoalquiler_comprobanteAlquiler int NOT NULL,
  id_vendedor_comprobanteAlquiler int NOT NULL,
  observacion_comprobanteAlquiler varchar(200),
  estado_comprobantealquiler varchar(10) DEFAULT 'Aprobado',
  id_comprobante_liquidacion int DEFAULT 0,
  constraint comprobanteAlquiler_unico UNIQUE (tipo_comprobanteAlquiler,nro_comprobanteAlquiler),
  constraint fk_id_contratoalquiler_comprobanteAlquiler foreign key (id_contratoalquiler_comprobanteAlquiler) references contratoalquiler(id_contratoalquiler) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint fk_id_vendedor_comprobanteAlquiler foreign key (id_vendedor_comprobanteAlquiler) references persona(id_persona) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint pk_comprobanteAlquiler primary key (id_comprobanteAlquiler)
);

CREATE TABLE item ( 
  id_item SERIAL NOT NULL,
  descripcion_item varchar(100),
  fecha_item date NOT NULL,
  monto_item decimal(20,2) DEFAULT 0,
  id_comprobanteAlquiler_item int NOT NULL,
  CONSTRAINT fk_id_comprobanteAlquiler_item FOREIGN KEY (id_comprobanteAlquiler_item)
      REFERENCES comprobanteAlquiler (id_comprobanteAlquiler) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_item primary key (id_item)
);


CREATE TABLE inmobiliaria.servicio(
  id_servicio SERIAL NOT NULL,
  detalle_servicio varchar(100) NOT NULL,
  constraint pk_servicio primary key (id_servicio)  
);

INSERT INTO inmobiliaria.servicio(detalle_servicio) VALUES ('MUNICIPAL'), ('EMOS'), ('EXPENSAS');

CREATE TABLE inmobiliaria.serviciocomprobante(
  id_serviciocomprobante SERIAL NOT NULL,
  id_servicio_serviciocomprobante int NOT NULL,
  id_comprobante_serviciocomprobante int NOT NULL,
  estado_serviciocomprobante int DEFAULT 0, -- 0:Pendiente   1:Abonado
  constraint un_servicio UNIQUE (id_servicio_serviciocomprobante, id_comprobante_serviciocomprobante),
  constraint fk_id_servicio_serviciocomprobante foreign key (id_servicio_serviciocomprobante) references inmobiliaria.servicio(id_servicio) ON UPDATE CASCADE ON DELETE RESTRICT,
  constraint fk_id_comprobante_serviciocomprobante foreign key (id_comprobante_serviciocomprobante) references inmobiliaria.comprobantealquiler(id_comprobanteAlquiler) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_serviciocomprobante primary key (id_serviciocomprobante)  
);


CREATE TABLE contratoventa ( 
  id_contratoventa SERIAL NOT NULL,
  nro_contratoventa int NOT NULL,
  observacion_contratoventa varchar(200), 
  path_contratoventa varchar(200),
  estado_contratoventa varchar(100),
  monto_contratoventa decimal(20,2) DEFAULT 0,
  comision_contratoventa decimal(20,2) DEFAULT 0,
  fecha_contratoventa date NOT NULL,
  id_inmueble_contratoventa int NOT NULL,
  id_comprador_contratoventa int NOT NULL,
  constraint fk_id_inmueble_contratoventa foreign key (id_inmueble_contratoventa) references inmueble(id_inmueble) ON UPDATE CASCADE ON DELETE RESTRICT,
  constraint fk_id_comprador_contratoventa foreign key (id_comprador_contratoventa) references persona(id_persona) ON UPDATE CASCADE ON DELETE RESTRICT,
  constraint pk_contratoventa primary key (id_contratoventa)  
);

CREATE TABLE garantea (   
  id_garantea SERIAL NOT NULL,
  id_garante_garantea int,
  id_contrato_garantea int,
  constraint fk_id_garante_garantea foreign key (id_garante_garantea) references persona(id_persona),
  constraint fk_id_contrato_garantea foreign key (id_contrato_garantea) references contratoalquiler(id_contratoalquiler),
  constraint garantea_unico UNIQUE (id_garante_garantea, id_contrato_garantea),
  constraint pk_garantea primary key (id_garantea)
);

CREATE TABLE garantev (   
  id_garantev SERIAL NOT NULL,
  id_garante_garantev int,
  id_contrato_garantev int,
  constraint fk_id_garante_garantev foreign key (id_garante_garantev) references persona(id_persona),
  constraint fk_id_contrato_garantev foreign key (id_contrato_garantev) references contratoventa(id_contratoventa),
  constraint pk_garantev primary key (id_garantev)
);

CREATE TABLE movimiento ( 
  id_movimiento SERIAL NOT NULL,
  descripcion_movimiento varchar(100),
  tipo_movimiento varchar(20),
  persona_movimiento varchar (50),
  monto_movimiento decimal(20,2) DEFAULT 0,
  fecha_movimiento DATE DEFAULT CURRENT_DATE,
  id_usuario_movimiento int NOT NULL,
  constraint fk_id_usuario_movimiento foreign key (id_usuario_movimiento) references usuario(id_usuario) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_movimiento primary key (id_movimiento)
);

CREATE TABLE pagoAlquiler ( 
  id_pagoAlquiler SERIAL NOT NULL,
  tipo_pagoAlquiler varchar(30) NOT NULL,
  fecha_pagoAlquiler date NOT NULL,
  monto_pagoAlquiler decimal(20,2) DEFAULT 0,
  id_comprobanteAlquiler_pagoAlquiler int NOT NULL,
  constraint pagoAlquiler_unico UNIQUE (id_comprobanteAlquiler_pagoAlquiler,fecha_pagoAlquiler,tipo_pagoAlquiler),
  constraint fk_id_comprobanteAlquiler_pagoAlquiler foreign key (id_comprobanteAlquiler_pagoAlquiler) references comprobanteAlquiler(id_comprobanteAlquiler) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_pagoAlquiler primary key (id_pagoAlquiler)
);



CREATE TABLE inmobiliaria.inquilinosAdicionales ( 
  id_inquilinosAdicionales SERIAL NOT NULL,
  id_contratoalquiler_inquilinosAdicionales int NOT NULL,
  id_inquilino_inquilinosAdicionales int NOT NULL,
  constraint inquilinosAdicionales_unico UNIQUE (id_contratoalquiler_inquilinosAdicionales,id_inquilino_inquilinosAdicionales),
  constraint fk_contratoalquiler_inquilinosAdicionales foreign key (id_contratoalquiler_inquilinosAdicionales) references inmobiliaria.contratoalquiler(id_contratoalquiler) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint fk_id_inquilino_inquilinosAdicionales foreign key (id_inquilino_inquilinosAdicionales) references inmobiliaria.persona(id_persona) ON UPDATE CASCADE ON DELETE NO ACTION,
  constraint pk_inquilinosAdicionales primary key (id_inquilinosAdicionales)
);


CREATE TABLE inmobiliaria.importeAlquiler ( 
  id_importeAlquiler SERIAL NOT NULL,
  importe_importeAlquiler decimal(20, 2) NOT NULL,
  fecha_importeAlquiler date NOT NULL,
  proximoajuste_importeAlquiler date NOT NULL,
  id_contratoalquiler_importeAlquiler int NOT NULL,  
  constraint fk_contratoalquiler_importeAlquiler foreign key (id_contratoalquiler_importeAlquiler) references inmobiliaria.contratoalquiler(id_contratoalquiler) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint pk_importeAlquiler primary key (id_importeAlquiler)
);

COMMIT;
