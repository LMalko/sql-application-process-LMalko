CREATE TABLE IF NOT EXISTS `mentors` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`first_name`	TEXT NOT NULL,
	`last_name`	TEXT NOT NULL,
	`nick_name`	TEXT ,
	`phone_number`	TEXT UNIQUE,
	`email`	TEXT UNIQUE,
	`city`	TEXT,
	`favourite_number`	INTEGER
);
CREATE TABLE IF NOT EXISTS `applicants` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`first_name`	TEXT NOT NULL,
	`last_name`	TEXT NOT NULL,
	`phone_number`	TEXT UNIQUE,
	`email`	TEXT UNIQUE,
	`application_code`	INTEGER NOT NULL UNIQUE
);