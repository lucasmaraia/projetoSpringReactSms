# projetoSpringReactSms

Dashboard de vendas full stack: a API expõe as vendas com filtro por período e o front-end permite disparar um SMS de notificação para o vendedor com um clique.

> Projeto de estudo (setembro/2022), baseado no DSMeta da DevSuperior. Foi meu primeiro projeto juntando back-end Spring e front-end React com TypeScript no mesmo repositório.

## Stack

**Back-end** (`backend/`)
- Java com Spring Boot (Web, Data JPA, Security)
- H2 em memória, populado por `import.sql`
- Twilio (envio de SMS)

**Front-end** (`frontend/`)
- React 18 + TypeScript
- Vite 2
- Axios, React Datepicker, React Toastify

## Modelo

`Sale`

| Campo        | Tipo        | Descrição                      |
|--------------|-------------|--------------------------------|
| `id`         | `Long`      |                                |
| `sellerName` | `String`    | Nome do vendedor               |
| `visited`    | `Integer`   | Clientes visitados             |
| `deals`      | `Integer`   | Negócios fechados              |
| `amount`     | `Double`    | Valor total vendido            |
| `date`       | `LocalDate` | Data da venda                  |

## Endpoints

| Método | Rota                       | Descrição                                            |
|--------|----------------------------|------------------------------------------------------|
| `GET`  | `/sales`                   | Lista as vendas, paginadas e filtradas por período   |
| `GET`  | `/sales/{id}/notification` | Envia o SMS com o resumo da venda                    |

O SMS enviado tem o formato: `O vendedor {sellerName} vendeu um total de {amount} na data de {date}`.

## Configuração

As credenciais do Twilio vêm de variáveis de ambiente:

```bash
export TWILIO_SID="..."
export TWILIO_KEY="..."
export TWILIO_PHONE_FROM="+1..."   # número comprado/trial no Twilio
export TWILIO_PHONE_TO="+55..."    # número de destino (verificado, se conta trial)
```

Crie a conta em <https://www.twilio.com/console>.

## Como rodar

Back-end:

```bash
cd backend
./mvnw spring-boot:run
```

Sobe em `http://localhost:8080`. O H2 é em memória e já vem com as vendas de exemplo do `import.sql`; o console fica em <http://localhost:8080/h2-console> (JDBC URL `jdbc:h2:mem:testdb`, usuário `sa`, senha vazia).

Front-end:

```bash
cd frontend
yarn install
yarn dev
```

Sobe em `http://localhost:5173` (ou a porta que o Vite indicar).

## Limitações

O banco em memória zera a cada restart. O número de destino do SMS é fixo na configuração, em vez de vir do cadastro do vendedor. Sem testes automatizados além do contexto padrão do Spring.
