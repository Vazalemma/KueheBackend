CREATE TABLE Question
(
	question_id SERIAL NOT NULL,
	topic varchar(255) NOT NULL,
	difficulty Integer NOT NULL,
	question varchar(255) NOT NULL,
	CONSTRAINT PK_Question PRIMARY KEY (question_id),
	CONSTRAINT check_difficulty CHECK (difficulty >=0 AND difficulty <= 100)
);

CREATE TABLE Response
(
	response_id SERIAL NOT NULL,
	question_reference_id Integer NOT NULL,
	answer varchar(255) NOT NULL,
	value boolean NOT NULL,
	CONSTRAINT PK_Response PRIMARY KEY (response_id),
	CONSTRAINT FK_Question_Reference FOREIGN KEY (question_reference_id) REFERENCES Question (question_id) ON DELETE CASCADE ON UPDATE CASCADE
);