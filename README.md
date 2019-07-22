NOTES:

To get Region ID use check box
	on return use ID's to get Constellation associated
		on return use ID's to get Systems associated


Create Tree display to show(order by #NPC kills)

	REGION
	-CONSTELLATION
	--SYSTEM(each system click to expand)
	----NPC KILLS(Auto Retrieve every 60 minutes)(in table)
	----POD KILLS(Auto Retrieve every 60 minutes)(in table)
	----SHIP KILLS(Auto Retrieve every 60 minutes)(in table)
	----System jumps(Auto Retrieve every 60 minutes)(in table)
	----Flag if constellation is an Incursion(in table, updates 24hrs)
	----Sov info(who owns the space)(in table, updates 24hrs, call is slow)
	------------------------------------
	----ACTIVE PILOTS IN SPACE(I don't think this is publicly available)
	---System Kill board info(Recent kills number of pilots involved)
	----List of all systems in jump range


**Functionality:** to select your staging system and display all systems in jump range and their information(same as before)
	---Expand on this in main view add ability to view all systems in jump range of the target system

Jump Range Calculator	D = √[(x₂ - x₁)² + (y₂ - y₁)² +(z₂ - z₁)²]

	Will need new database table with all system cords
	post for all system id's
	post all id's to get cords
	create check if security level is > 0 flag high security space
	need to figure out how to make the numbers meaningful in Eve terms(lightyears)


**Functionality:** to paste local pilots and get dossier of the characters
	Graphic of pilot
	name
	corp
	alliance
	sec status
	recent kills
	recent losses
	common ships and fittings

**Functionality:** travel paths
	record jumps/h for a region and then map connected systems to find high traffic patterns
	
TO DO:
    
    DeDupe Logic for all tables
    Jump Range Calculations
    Kill Board Statistics
        -systems
        -Pilots
    All Front End work



