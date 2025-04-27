ALTER TABLE fre_engineering_office
    ADD COLUMN facebook_link VARCHAR(255),
    ADD COLUMN linkedin_link VARCHAR(255),
    ADD COLUMN behance_link VARCHAR(255);


ALTER TABLE fre_engineer
    ADD COLUMN facebook_link VARCHAR(255);

ALTER TABLE fre_technical_worker
    ADD COLUMN facebook_link VARCHAR(255),
    ADD COLUMN linkedin_link VARCHAR(255),
    ADD COLUMN behance_link VARCHAR(255);