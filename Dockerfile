# Use a imagem oficial do PostgreSQL
FROM postgres:latest

# Define variáveis de ambiente para o PostgreSQL
ENV POSTGRES_USER perguntou
ENV POSTGRES_PASSWORD quemteperguntou
ENV POSTGRES_DB perguntou

# Copie o arquivo de configuração personalizado (se necessário)
# COPY ./path/to/custom/pg_config.conf /etc/postgresql/postgresql.conf

# Exponha a porta padrão do PostgreSQL
EXPOSE 5432

# Opcional: adicione inicialização de scripts SQL
# COPY ./path/to/sql-scripts/ /docker-entrypoint-initdb.d/

# O comando de inicialização padrão para a imagem do PostgreSQL
CMD ["postgres"]
