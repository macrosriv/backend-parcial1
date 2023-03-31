-- Crear tabla de clientes
CREATE TABLE clientes (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  nro_documento VARCHAR(50) UNIQUE NOT NULL,
  tipo_documento VARCHAR(10) NOT NULL,
  nacionalidad VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefono VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL
);

-- Crear tabla de conceptos de uso de puntos
CREATE TABLE conceptos_uso_puntos (
  id SERIAL PRIMARY KEY,
  descripcion VARCHAR(50) NOT NULL,
  puntos_requeridos INTEGER NOT NULL
);

-- Crear tabla de reglas de asignación de puntos
CREATE TABLE reglas_asignacion_puntos (
  id SERIAL PRIMARY KEY,
  limite_inferior INTEGER,
  limite_superior INTEGER,
  monto_equivalencia INTEGER NOT NULL
);

-- Crear tabla de parametrización de vencimientos de puntos
CREATE TABLE parametrizacion_vencimientos_puntos (
  id SERIAL PRIMARY KEY,
  fecha_inicio_validez DATE NOT NULL,
  fecha_fin_validez DATE NOT NULL,
  dias_duracion_puntaje INTEGER NOT NULL
);

-- Crear tabla de bolsa de puntos
CREATE TABLE bolsa_puntos (
  id SERIAL PRIMARY KEY,
  id_cliente INTEGER NOT NULL REFERENCES clientes(id),
  fecha_asignacion_puntaje DATE NOT NULL,
  fecha_caducidad_puntaje DATE NOT NULL,
  puntaje_asignado INTEGER NOT NULL,
  puntaje_utilizado INTEGER NOT NULL,
  saldo_puntos INTEGER NOT NULL,
  monto_operacion INTEGER NOT NULL
);

-- Crear tabla de uso de puntos
CREATE TABLE uso_puntos (
  id SERIAL PRIMARY KEY,
  id_cliente INTEGER NOT NULL REFERENCES clientes(id),
  puntaje_utilizado INTEGER NOT NULL,
  fecha DATE NOT NULL,
  concepto_uso_punto_id INTEGER NOT NULL REFERENCES conceptos_uso_puntos(id)
);

-- Crear tabla de detalle de uso de puntos
CREATE TABLE detalle_uso_puntos (
  id SERIAL PRIMARY KEY,
  uso_puntos_id INTEGER NOT NULL REFERENCES uso_puntos(id),
  bolsa_puntos_id INTEGER NOT NULL REFERENCES bolsa_puntos(id),
  puntaje_utilizado INTEGER NOT NULL
);
