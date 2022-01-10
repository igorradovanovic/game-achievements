CREATE TABLE Achievements(
     ach_id              VARCHAR(50) UNIQUE NOT NULL,
     ach_display_name        VARCHAR(50) NOT NULL,
     ach_description       VARCHAR(250) NOT NULL,
     ach_icon           VARCHAR(250) NOT NULL,
     ach_display_order INT,
     ach_game_id VARCHAR(50) NOT NULL,
     ach_sys_create_date  TIMESTAMP,
     ach_sys_update_date  TIMESTAMP,
     PRIMARY KEY(ach_id),
     CONSTRAINT fk_game_id
      FOREIGN KEY(ach_game_id) 
       REFERENCES Game(gam_id)
  ) 
  
