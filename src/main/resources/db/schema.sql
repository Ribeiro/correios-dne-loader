-- SCHEMA: correios-dne-loader
-- DROP SCHEMA IF EXISTS "correios-dne-loader" ;

CREATE SCHEMA IF NOT EXISTS "correios-dne-loader"
    AUTHORIZATION postgres;


-- Table: correios-dne-loader.log_bairro
-- DROP TABLE IF EXISTS "correios-dne-loader".log_bairro;

CREATE TABLE IF NOT EXISTS "correios-dne-loader".log_bairro
(
    cod_municipio integer,
    codigo bigint,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    descricao_bairro character varying(255) COLLATE pg_catalog."default",
    nome_bairro character varying(255) COLLATE pg_catalog."default",
    uf character varying(2) COLLATE pg_catalog."default",
    CONSTRAINT log_bairro_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "correios-dne-loader".log_bairro
    OWNER to postgres;

-- Table: correios-dne-loader.log_localidade
-- DROP TABLE IF EXISTS "correios-dne-loader".log_localidade;

CREATE TABLE IF NOT EXISTS "correios-dne-loader".log_localidade
(
    cod_subordinacao integer,
    indicador_dados integer,
    codigo bigint,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    cep character varying(10) COLLATE pg_catalog."default",
    nome_abreviado character varying(255) COLLATE pg_catalog."default",
    nome_localidade character varying(255) COLLATE pg_catalog."default",
    tipo_localidade character varying(255) COLLATE pg_catalog."default",
    uf character varying(2) COLLATE pg_catalog."default",
    CONSTRAINT log_localidade_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "correios-dne-loader".log_localidade
    OWNER to postgres;


-- Table: correios-dne-loader.log_logradouro
-- DROP TABLE IF EXISTS "correios-dne-loader".log_logradouro;

CREATE TABLE IF NOT EXISTS "correios-dne-loader".log_logradouro
(
    cod_bairro integer,
    cod_municipio integer,
    codigo bigint,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    cep character varying(10) COLLATE pg_catalog."default",
    descricao_completa character varying(255) COLLATE pg_catalog."default",
    nome_bairro character varying(255) COLLATE pg_catalog."default",
    nome_logradouro character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    tipo_logradouro character varying(255) COLLATE pg_catalog."default",
    uf character varying(2) COLLATE pg_catalog."default",
    CONSTRAINT log_logradouro_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "correios-dne-loader".log_logradouro
    OWNER to postgres;