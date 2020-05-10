DROP TABLE IF EXISTS feedback;

CREATE TABLE feedback (
  feedback_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250),
  email VARCHAR(250),
  message VARCHAR(250) NOT NULL,
  submission_date DATE
);

