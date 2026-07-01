CREATE EXTENSION IF NOT EXISTS "pgcrypto";

----------------------------------------------------
-- CURRENCIES
----------------------------------------------------

CREATE TABLE currencies
(
    id UUID PRIMARY KEY,

    code VARCHAR(3) NOT NULL UNIQUE,

    name VARCHAR(100) NOT NULL,

    symbol VARCHAR(10) NOT NULL
);

----------------------------------------------------
-- ACCOUNT TYPES
----------------------------------------------------

CREATE TABLE account_types
(
    id UUID PRIMARY KEY,

    name VARCHAR(50) NOT NULL UNIQUE,

    description VARCHAR(255) NOT NULL
);

----------------------------------------------------
-- ACCOUNTS
----------------------------------------------------

CREATE TABLE accounts
(
    id UUID PRIMARY KEY,

    account_number VARCHAR(30) NOT NULL UNIQUE,

    owner_id UUID NOT NULL,

    owner_type VARCHAR(30) NOT NULL,

    currency_id UUID NOT NULL,

    account_type_id UUID NOT NULL,

    balance NUMERIC(19,2) NOT NULL DEFAULT 0,

    account_status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    version BIGINT DEFAULT 0,

    CONSTRAINT fk_accounts_currency
        FOREIGN KEY (currency_id)
            REFERENCES currencies(id),

    CONSTRAINT fk_accounts_type
        FOREIGN KEY (account_type_id)
            REFERENCES account_types(id)
);

----------------------------------------------------
-- ACCOUNT STATUS HISTORY
----------------------------------------------------

CREATE TABLE account_status_history
(
    id UUID PRIMARY KEY,

    account_id UUID NOT NULL,

    old_status VARCHAR(30),

    new_status VARCHAR(30),

    reason VARCHAR(255),

    changed_by VARCHAR(100),

    changed_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_history_account
        FOREIGN KEY(account_id)
            REFERENCES accounts(id)
            ON DELETE CASCADE
);

----------------------------------------------------
-- INDEXES
----------------------------------------------------

CREATE INDEX idx_accounts_owner
    ON accounts(owner_id);

CREATE INDEX idx_accounts_number
    ON accounts(account_number);

CREATE INDEX idx_accounts_currency
    ON accounts(currency_id);

CREATE INDEX idx_accounts_type
    ON accounts(account_type_id);

CREATE INDEX idx_accounts_status
    ON accounts(account_status);

CREATE INDEX idx_history_account
    ON account_status_history(account_id);

CREATE INDEX idx_history_changed_at
    ON account_status_history(changed_at);

INSERT INTO currencies
(id, code, name, symbol)
VALUES

    ('11111111-1111-1111-1111-111111111111','RUB','Russian Ruble','₽'),

    ('22222222-2222-2222-2222-222222222222','USD','US Dollar','$'),

    ('33333333-3333-3333-3333-333333333333','EUR','Euro','€'),

    ('44444444-4444-4444-4444-444444444444','GBP','British Pound','£'),

    ('55555555-5555-5555-5555-555555555555','JPY','Japanese Yen','¥'),

    ('66666666-6666-6666-6666-666666666666','CNY','Chinese Yuan','¥'),

    ('77777777-7777-7777-7777-777777777777','CHF','Swiss Franc','CHF'),

    ('88888888-8888-8888-8888-888888888888','KZT','Kazakh Tenge','₸');

INSERT INTO account_types
(id,name,description)
VALUES

    ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
     'CURRENT',
     'Current account'),

    ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
     'SAVINGS',
     'Savings account'),

    ('cccccccc-cccc-cccc-cccc-cccccccccccc',
     'DEPOSIT',
     'Deposit account'),

    ('dddddddd-dddd-dddd-dddd-dddddddddddd',
     'CREDIT',
     'Credit account');

INSERT INTO accounts
(
    id,
    account_number,
    owner_id,
    owner_type,
    currency_id,
    account_type_id,
    balance,
    account_status,
    created_at,
    updated_at,
    created_by,
    updated_by,
    version
)
VALUES
    (
        gen_random_uuid(),
        '40817810000000000001',
        gen_random_uuid(),
        'INDIVIDUAL',
        '22222222-2222-2222-2222-222222222222',
        'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        10500.25,
        'ACTIVE',
        NOW(),
        NOW(),
        'system',
        'system',
        0
    ),

    (
        gen_random_uuid(),
        '40817810000000000002',
        gen_random_uuid(),
        'CORPORATE',
        '11111111-1111-1111-1111-111111111111',
        'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        9800000.00,
        'ACTIVE',
        NOW(),
        NOW(),
        'system',
        'system',
        0
    );

INSERT INTO account_status_history
(
    id,
    account_id,
    old_status,
    new_status,
    reason,
    changed_by,
    changed_at
)

SELECT

    gen_random_uuid(),

    id,

    'ACTIVE',

    'ACTIVE',

    'Initial status',

    'system',

    NOW()

FROM accounts;