drop schema if exists codetrip;
create schema if not exists codetrip default character set utf8 collate utf8_general_ci;
use codetrip;

drop table if exists User;
drop table if exists Access;
drop table if exists Problem;
drop table if exists Contest;
drop table if exists Solution;
drop table if exists ContestProblem;
drop table if exists TestCase;
drop table if exists ProblemStatistic;
drop table if exists Participant;
drop table if exists Rank;
drop table if exists Membership;

create table if not exists User
(
    id integer primary key not null auto_increment,
    password varchar(100) not null,
    nike_name varchar(100),
    register_date varchar(100) not null,
    email varchar(100) not null,
    role varchar(20),
    nationality varchar(100),
    public_info varchar(10) not null,
    sex varchar(10) not null,
    age integer not null
);

create table if not exists Access
(
	user_id integer primary key not null,
    ip_addr varchar(40),
    access_time varchar(100) not null
);

create table if not exists Problem
(
	problem_id integer primary key not null auto_increment,
    title varchar(100) not null,
    user_id integer not null,
    contest_id integer not null,
    description text not null,
    input_description text not null,
    output_description text not null,
    sample_input text not null,
    sample_output text not null,
    time_limit integer not null,
    memory_limit integer not null,
    hint text,
    source text,
    special_judge varchar(10) not null,
    visiable varchar(10) not null
);

create table if not exists ContestProblem
(
    contest_id integer not null,
    problem_id integer not null
);

create table if not exists Contest
(
	contest_id integer primary key not null auto_increment,
    user_id integer not null,
    title varchar(100) not null,
    create_date varchar(100) not null,
    start_time varchar(100) not null,
    end_time varchar(100) not null,
    private varchar(10) not null,
    password varchar(100)
);

create table if not exists Solution
(
	solution_id integer primary key not null auto_increment,
    team_id integer,
    user_id integer,
    problem_id integer not null,
    contest_id integer,
    use_time integer,
    use_memory integer,
    date varchar(100) not null,
    language varchar(20) not null,
    result varchar(20),
    compile_output text,
    code_context text not null
);

create table if not exists TestCase
(
    id integer primary key not null auto_increment,
    problem_id integer not null,
    test_data text not null,
    standard_output text not null
);

create table if not exists ProblemStatistic
(
	problem_id integer not null,
    submissions integer not null,
    accept integer not null,
    compile_error integer not null,
    wrong_answer integer not null,
    time_limit_error integer not null,
    mem_limit_error integer not null,
    presentation_error integer not null,
    runtime_error integer not null,
    output_limit_error integer not null,
    system_error integer not null
);

create table if not exists Participant
(
	team_id	integer not null primary key auto_increment,
	contest_id integer not null,
    team_name varchar(50) not null,
    password varchar(100) not null,
    register_date varchar(100) not null
);

create table if not exists Rank
(
	rank_id integer not null primary key auto_increment,
    team_id integer not null,
    contest_id integer not null,
    penalty integer not null
);

create table if not exists Membership
(
	team_id integer not null,
    user_id integer not null
);
