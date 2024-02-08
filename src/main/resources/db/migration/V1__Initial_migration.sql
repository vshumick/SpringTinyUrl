DO $$
BEGIN
    CREATE SEQUENCE public.url_seq1
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 52
        START 1
        CACHE 1
        CYCLE;

    CREATE SEQUENCE public.url_seq2
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 52
        START 1
        CACHE 1
        CYCLE;

    CREATE SEQUENCE public.url_seq3
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 52
        START 1
        CACHE 1
        CYCLE;

    CREATE SEQUENCE public.url_seq4
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 52
        START 1
        CACHE 1
        CYCLE;

    CREATE SEQUENCE public.url_seq5
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 52
        START 1
        CACHE 1
        CYCLE;

    CREATE SEQUENCE public.url_seq6
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 52
        START 1
        CACHE 1
        CYCLE;

    -- DROP FUNCTION public.increment_counter();
    CREATE OR REPLACE FUNCTION public.increment_counter()
     RETURNS text
     LANGUAGE plpgsql
    AS $function$
    DECLARE
        -- Переменные для хранения значений счетчиков
    seq_val1 INT;
        seq_val2 INT;
        seq_val3 INT;
        seq_val4 INT;
        seq_val5 INT;
        seq_val6 INT;
    BEGIN
        -- Получаем значение для последнего счетчика и увеличиваем его
    SELECT nextval('url_seq6') INTO seq_val6;

    -- Проверяем, не достиг ли счетчик максимального значения
    IF seq_val6 = 1 THEN
            -- Сбрасываем счетчик и увеличиваем следующий
    SELECT nextval('url_seq5') INTO seq_val5;

    IF seq_val5 = 1 THEN
    SELECT nextval('url_seq4') INTO seq_val4;

    IF seq_val4 = 1 THEN
    SELECT nextval('url_seq3') INTO seq_val3;

    IF seq_val3 = 1 THEN
    SELECT nextval('url_seq2') INTO seq_val2;

    IF seq_val2 = 1 THEN
    SELECT nextval('url_seq1') INTO seq_val1;

    ELSE
    SELECT pg_sequence_last_value('url_seq2') INTO seq_val2;
    END IF;
    ELSE
    SELECT pg_sequence_last_value('public.url_seq3') INTO seq_val3;
    END IF;
    ELSE
    SELECT pg_sequence_last_value('public.url_seq4') INTO seq_val4;
    END IF;
    ELSE
    SELECT pg_sequence_last_value('public.url_seq5') INTO seq_val5;
    END IF;
    END IF;
    SELECT pg_sequence_last_value('public.url_seq6') INTO seq_val6;
    SELECT pg_sequence_last_value('public.url_seq5') INTO seq_val5;
    SELECT pg_sequence_last_value('public.url_seq4') INTO seq_val4;
    SELECT pg_sequence_last_value('public.url_seq3') INTO seq_val3;
    SELECT pg_sequence_last_value('public.url_seq2') INTO seq_val2;
    SELECT pg_sequence_last_value('public.url_seq1') INTO seq_val1;

    -- Возвращаем значения счетчиков в виде строки, разделенной точками
    RETURN seq_val1 || '.' || seq_val2 || '.' || seq_val3 || '.' || seq_val4 || '.' || seq_val5 || '.' || seq_val6;
    END;
    $function$
    ;


END $$;