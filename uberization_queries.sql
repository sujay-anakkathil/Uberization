
CREATE DATABASE uberization;
CREATE SEQUENCE user_type_seq;
CREATE SEQUENCE user_id_seq;
CREATE SEQUENCE skill_id_seq;
CREATE SEQUENCE job_posting_id_seq;


CREATE TABLE uberization.User_Type_DM
(
    user_type_id INTEGER DEFAULT NEXTVAL('user_type_seq') NOT NULL,
    user_type_text character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "User_Type_DM_pkey" PRIMARY KEY (user_type_id)
)

CREATE TABLE uberization.User_Credentials
(
    user_id integer NOT NULL,
    user_email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(15) COLLATE pg_catalog."default" NOT NULL,
    user_type_id smallint NOT NULL,
    registered_on timestamp without time zone NOT NULL,
    last_login timestamp without time zone NOT NULL,
    CONSTRAINT credentials_pkey PRIMARY KEY (user_id, user_email),
    CONSTRAINT "unique Id" UNIQUE (user_id)
,
    CONSTRAINT "unique email" UNIQUE (user_email)
,
    CONSTRAINT user_type FOREIGN KEY (user_type_id)
        REFERENCES uberization.User_Type_DM (user_type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE uberization.User_Profile
(
    user_id INTEGER DEFAULT NEXTVAL('user_id_seq') NOT NULL,
    first_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(30) NOT NULL,
    verified boolean,
    rating real,
    photo_src character varying(255) COLLATE pg_catalog."default",
    work_resume bytea,
    CONSTRAINT "User_Profile_pkey" PRIMARY KEY (user_id)
)


CREATE TABLE uberization.Skill_DM
(
    skill_id INTEGER DEFAULT NEXTVAL('skill_id_seq') NOT NULL,
    skill_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    skill_desc text COLLATE pg_catalog."default",
    CONSTRAINT "Skill_DM_pkey" PRIMARY KEY (skill_id)
)

CREATE TABLE uberization.Work_Type_DM
(
    work_type_id smallint NOT NULL,
    work_type_text character varying(50) COLLATE pg_catalog."default" NOT NULL,
    work_type_desc character varying(500) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Work_Type_DM_pkey" PRIMARY KEY (work_type_id)
)

CREATE TABLE uberization.Job_Posting_Details
(
    job_posting_id INTEGER DEFAULT NEXTVAL('job_posting_id_seq') NOT NULL,
    job_date date NOT NULL,
    work_type_id smallint NOT NULL,
    work_count integer NOT NULL,
    job_post_date date NOT NULL,
    job_resp_deadline time without time zone NOT NULL,
    CONSTRAINT "Job_Posting_Details_pkey" PRIMARY KEY (job_posting_id),
    CONSTRAINT "workFK" FOREIGN KEY (work_type_id)
        REFERENCES uberization.Work_Type_DM (work_type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE uberization.Job_Assignment_Details
(
    job_posting_id smallint NOT NULL,
    user_id smallint NOT NULL,
    available_count smallint NOT NULL,
    assigned_count smallint,
    CONSTRAINT "Job_Assignment_Details_pkey" PRIMARY KEY (job_posting_id, user_id),
    CONSTRAINT "jobFK" FOREIGN KEY (job_posting_id)
        REFERENCES uberization.Job_Posting_Details (job_posting_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "userFk" FOREIGN KEY (user_id)
        REFERENCES uberization.User_Profile (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE uberization.Job_Completion_Details
(
		job_posting_id smallint NOT NULL,
		user_id smallint NOT NULL,
		status character varying(30) COLLATE pg_catalog."default",
		completed_count smallint,
		rating smallint,
		accepted_count smallint,
    CONSTRAINT "Job_Completion_Details_pkey" PRIMARY KEY (job_posting_id, user_id),
    CONSTRAINT "jobFK" FOREIGN KEY (job_posting_id)
        REFERENCES uberization.Job_Posting_Details (job_posting_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "userFk" FOREIGN KEY (user_id)
        REFERENCES uberization.User_Profile (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
