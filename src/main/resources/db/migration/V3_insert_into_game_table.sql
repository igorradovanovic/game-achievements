INSERT INTO public.game(
	gam_id, gam_display_name)
	VALUES 
	(gen_random_uuid()::varchar, 'NBA 2k22'),
	(gen_random_uuid()::varchar, 'COUNTER STRIKE:GO'),
	(gen_random_uuid()::varchar, 'CYBER PUNK');
