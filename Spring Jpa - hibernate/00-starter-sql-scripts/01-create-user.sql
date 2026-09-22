-- Drop user first if they exist
DROP USER if exists 'springstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'sherif'@'%' IDENTIFIED BY 'sherif';

GRANT ALL PRIVILEGES ON * . * TO 'sherif'@'%';