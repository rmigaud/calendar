CREATE TABLE IF NOT EXISTS UserStories (
  id INTEGER AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  status VARCHAR(255) NOT NULL,
  lastUpdated TIMESTAMP,
  url VARCHAR(255),
  primary key (id)
);


INSERT INTO UserStories (title, description, status, lastUpdated, url )
VALUES('first-title','first-description', 'IN_PROGRESS',CURRENT_TIMESTAMP,
'first-url');