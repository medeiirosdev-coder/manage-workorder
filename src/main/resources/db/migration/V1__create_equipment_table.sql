CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE equipment (

    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    code VARCHAR(30) NOT NULL,
    name VARCHAR(150) NOT NULL,
    local VARCHAR(200) NOT NULL,
    active BOOLEAN NOT NULL

);