ALTER TABLE user ADD COLUMN cover_photo VARCHAR(255);

ALTER TABLE fre_engineering_office
    MODIFY COLUMN personal_card_path VARCHAR(255) NULL,
    MODIFY COLUMN tax_card_path VARCHAR(255) NULL,
    MODIFY COLUMN commercial_register_path VARCHAR(255) NULL;


INSERT INTO common_portal_config (created_date,modified_date,status_code,config_key,config_value) VALUES
  (now(),now(),NULL,'COVER_PHOTO','user/cover/'),
  (now(),now(),NULL,'PERSONAL_CARD','engineering/office/personal_/'),
  (now(),now(),NULL,'TAX_CARD','engineering/office/tax/'),
  (now(),now(),NULL,'COMMERCIAL_REGISTER','engineering/office/commercial/');