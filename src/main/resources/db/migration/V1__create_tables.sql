CREATE TABLE tb_schedules (
    id SERIAL PRIMARY KEY,
    title VARCHAR(120) NOT NULL,
    description TEXT,
    initial_date TIMESTAMP NOT NULL,
    final_date TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'SCHEDULED',
    user VARCHAR(80) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    constraint ck_status check(status in ('SCHEDULED', 'CANCELED', 'COMPLETED')),
    constraint ck_intervalor CHECK (initial_date , final_date)
);

CREATE INDEX idx_ag_usuario_inicio_fim ON tb_agendamento
(user, initial_date, final_date);

CREATE OR REPLACE FUNCTION set_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_set_updated_at
BEFORE UPDATE ON tb_agendamento
FOR EACH ROW
EXECUTE FUNCTION set_updated_at();