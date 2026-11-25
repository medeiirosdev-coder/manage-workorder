CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE workorder (

    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(600) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP NOT NULL,
    equipment_id UUID NOT NULL,
    FOREIGN KEY (equipment_id) REFERENCES equipment(id)

);