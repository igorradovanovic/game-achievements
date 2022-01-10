INSERT INTO public.achievements
(ach_id, ach_display_name, ach_description,ach_icon, ach_display_order,ach_game_id, ach_sys_create_date,  ach_sys_update_date)
VALUES(
     gen_random_uuid()::varchar,
     'Game-Runner','Play the game for the first time.',
     'game-runner-icon', 1,  
(SELECT g.gam_id from game g where gam_display_name = 'NBA 2k22'), NOW(), NOW()),
(
     gen_random_uuid()::varchar,
     'Sniper','Kill with a sniper.',
     'sniper-icon', 1,  
(SELECT g.gam_id from game g where gam_display_name = 'COUNTER STRIKE:GO'), NOW(), NOW()),
(
     gen_random_uuid()::varchar,
     'Gamer','Enter the Cyber Punk World for the first time.',
     'gamer-icon', 1,  
(SELECT g.gam_id from game g where gam_display_name = 'CYBER PUNK'),  NOW(), NOW()) 
