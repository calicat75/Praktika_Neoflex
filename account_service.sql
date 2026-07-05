--
-- PostgreSQL database dump
--

\restrict VdiPOR2M6XCRyqq55k77fdmBvKyaT6zPHaQqPs7QFhQfRpyH4fwlysSKz6YkO4q

-- Dumped from database version 16.14 (Debian 16.14-1.pgdg13+1)
-- Dumped by pg_dump version 16.14 (Debian 16.14-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account_status_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account_status_history (
    id uuid NOT NULL,
    changed_at timestamp(6) without time zone,
    changed_by character varying(255),
    new_status character varying(255),
    old_status character varying(255),
    reason text,
    account_id uuid,
    CONSTRAINT account_status_history_new_status_check CHECK (((new_status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'BLOCKED'::character varying, 'FROZEN'::character varying, 'CLOSED'::character varying])::text[]))),
    CONSTRAINT account_status_history_old_status_check CHECK (((old_status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'BLOCKED'::character varying, 'FROZEN'::character varying, 'CLOSED'::character varying])::text[])))
);


ALTER TABLE public.account_status_history OWNER TO postgres;

--
-- Name: account_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account_types (
    id uuid NOT NULL,
    description text,
    name character varying(255) NOT NULL,
    CONSTRAINT account_types_name_check CHECK (((name)::text = ANY ((ARRAY['CURRENT'::character varying, 'SAVINGS'::character varying, 'DEPOSIT'::character varying, 'CREDIT'::character varying])::text[])))
);


ALTER TABLE public.account_types OWNER TO postgres;

--
-- Name: accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accounts (
    id uuid NOT NULL,
    account_number character varying(255) NOT NULL,
    account_status character varying(255),
    balance numeric(19,2) NOT NULL,
    created_at timestamp(6) without time zone,
    created_by character varying(255),
    owner_id uuid NOT NULL,
    owner_type character varying(255) NOT NULL,
    updated_at timestamp(6) without time zone,
    updated_by character varying(255),
    version bigint NOT NULL,
    account_type_id uuid,
    currency_id uuid,
    CONSTRAINT accounts_account_status_check CHECK (((account_status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'BLOCKED'::character varying, 'FROZEN'::character varying, 'CLOSED'::character varying])::text[]))),
    CONSTRAINT accounts_owner_type_check CHECK (((owner_type)::text = ANY ((ARRAY['INDIVIDUAL'::character varying, 'CORPORATE'::character varying])::text[])))
);


ALTER TABLE public.accounts OWNER TO postgres;

--
-- Name: currencies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.currencies (
    id uuid NOT NULL,
    code character varying(3) NOT NULL,
    name character varying(255) NOT NULL,
    symbol character varying(255)
);


ALTER TABLE public.currencies OWNER TO postgres;

--
-- Data for Name: account_status_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account_status_history (id, changed_at, changed_by, new_status, old_status, reason, account_id) FROM stdin;
98afe153-a5d2-4afc-a4ee-6e49f1152859	2026-07-01 17:50:58.19799	system	ACTIVE	ACTIVE	Initial status	fb226e43-b9ea-49d7-9147-980c3ebc503b
f83afa4b-0c41-4402-9e9e-723286e28ba1	2026-07-01 17:50:58.19799	system	ACTIVE	ACTIVE	Initial status	241b093f-366e-4f3f-845c-76f604a010f4
\.


--
-- Data for Name: account_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account_types (id, description, name) FROM stdin;
aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa	Current account	CURRENT
bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb	Savings account	SAVINGS
cccccccc-cccc-cccc-cccc-cccccccccccc	Deposit account	DEPOSIT
dddddddd-dddd-dddd-dddd-dddddddddddd	Credit account	CREDIT
\.


--
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accounts (id, account_number, account_status, balance, created_at, created_by, owner_id, owner_type, updated_at, updated_by, version, account_type_id, currency_id) FROM stdin;
fb226e43-b9ea-49d7-9147-980c3ebc503b	40817810000000000001	ACTIVE	10500.25	2026-07-01 17:50:58.19505	system	492604da-8596-4110-9fbc-7aad3d5c019e	INDIVIDUAL	2026-07-01 17:50:58.19505	system	0	aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa	22222222-2222-2222-2222-222222222222
241b093f-366e-4f3f-845c-76f604a010f4	40817810000000000002	ACTIVE	9800000.00	2026-07-01 17:50:58.19505	system	318bdc5d-e535-466e-8fab-eae0b7dc214b	CORPORATE	2026-07-01 17:50:58.19505	system	0	bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb	11111111-1111-1111-1111-111111111111
\.


--
-- Data for Name: currencies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.currencies (id, code, name, symbol) FROM stdin;
11111111-1111-1111-1111-111111111111	RUB	Russian Ruble	₽
22222222-2222-2222-2222-222222222222	USD	US Dollar	$
33333333-3333-3333-3333-333333333333	EUR	Euro	€
44444444-4444-4444-4444-444444444444	GBP	British Pound	£
55555555-5555-5555-5555-555555555555	JPY	Japanese Yen	¥
66666666-6666-6666-6666-666666666666	CNY	Chinese Yuan	¥
77777777-7777-7777-7777-777777777777	CHF	Swiss Franc	CHF
88888888-8888-8888-8888-888888888888	KZT	Kazakh Tenge	₸
\.


--
-- Name: account_status_history account_status_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_status_history
    ADD CONSTRAINT account_status_history_pkey PRIMARY KEY (id);


--
-- Name: account_types account_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_types
    ADD CONSTRAINT account_types_pkey PRIMARY KEY (id);


--
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);


--
-- Name: currencies currencies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currencies
    ADD CONSTRAINT currencies_pkey PRIMARY KEY (id);


--
-- Name: currencies uk5r2dfxl1m7vus47ma0y05sflt; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currencies
    ADD CONSTRAINT uk5r2dfxl1m7vus47ma0y05sflt UNIQUE (code);


--
-- Name: accounts uk6kplolsdtr3slnvx97xsy2kc8; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT uk6kplolsdtr3slnvx97xsy2kc8 UNIQUE (account_number);


--
-- Name: account_types ukn89de3futkjcylw33x7yspjov; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_types
    ADD CONSTRAINT ukn89de3futkjcylw33x7yspjov UNIQUE (name);


--
-- Name: idx_accounts_currency; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_accounts_currency ON public.accounts USING btree (currency_id);


--
-- Name: idx_accounts_number; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_accounts_number ON public.accounts USING btree (account_number);


--
-- Name: idx_accounts_owner; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_accounts_owner ON public.accounts USING btree (owner_id);


--
-- Name: idx_accounts_status; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_accounts_status ON public.accounts USING btree (account_status);


--
-- Name: idx_accounts_type; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_accounts_type ON public.accounts USING btree (account_type_id);


--
-- Name: idx_history_account; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_history_account ON public.account_status_history USING btree (account_id);


--
-- Name: idx_history_changed_at; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_history_changed_at ON public.account_status_history USING btree (changed_at);


--
-- Name: accounts fk8n01exlilvgdahg56bagoqcj6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT fk8n01exlilvgdahg56bagoqcj6 FOREIGN KEY (account_type_id) REFERENCES public.account_types(id);


--
-- Name: account_status_history fkcla5kltem26p8ngghmlk25ub1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account_status_history
    ADD CONSTRAINT fkcla5kltem26p8ngghmlk25ub1 FOREIGN KEY (account_id) REFERENCES public.accounts(id);


--
-- Name: accounts fks08d0ccyak63pou9tfk093dbk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT fks08d0ccyak63pou9tfk093dbk FOREIGN KEY (currency_id) REFERENCES public.currencies(id);


--
-- PostgreSQL database dump complete
--

\unrestrict VdiPOR2M6XCRyqq55k77fdmBvKyaT6zPHaQqPs7QFhQfRpyH4fwlysSKz6YkO4q

