
CREATE USER adrian WITH ENCRYPTED PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE driver TO adrian;
GRANT ALL PRIVILEGES ON SCHEMA public TO adrian;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO adrian;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO adrian;

GRANT CREATE ON DATABASE driver TO adrian;
GRANT CREATE ON SCHEMA public TO adrian;
