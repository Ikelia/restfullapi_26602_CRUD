-- ============================================
-- Create Database for Spring Boot REST API
-- ============================================
-- Run this script in pgAdmin to create the database
-- Make sure you're connected to the default 'postgres' database first

-- Drop database if exists (optional - be careful!)
-- DROP DATABASE IF EXISTS spring_rest_api_db;

-- Create the database
CREATE DATABASE spring_rest_api_db
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE spring_rest_api_db
    IS 'Database for Spring Boot REST API Practice Questions';
