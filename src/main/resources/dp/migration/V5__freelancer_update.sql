ALTER TABLE fre_engineer
    ADD COLUMN bio TEXT,
ADD COLUMN linkedin_link VARCHAR(255) NOT null,
ADD COLUMN behance_link VARCHAR(255);


ALTER TABLE fre_technical_worker
    ADD COLUMN bio TEXT;


ALTER TABLE user
    ADD COLUMN personal_photo VARCHAR(255);