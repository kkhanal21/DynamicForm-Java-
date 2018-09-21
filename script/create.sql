--create master entities
--1.create form table
--2.create form field table

DROP TABLE IF EXISTS tbl_forms cascade;
DROP TABLE IF EXISTS tbl_form_fields cascade;



--1) create form table
create table tbl_forms(
    form_id serial primary key not null,
    form_name varchar (50) not null,
    description text not null,
    added_date TIMESTAMP default CURRENT_TIMESTAMP,    
    status boolean default false
--     CONSTRAINT fk_gender_id_parents FOREIGN KEY (gender_id) REFERENCES tbl_genders(gender_id)
);



--2) create form field table
create table tbl_form_fields(
    field_id serial primary key not null,
    field_name varchar (50) not null
    )
    
--3) create form Option table
create TYPE f_type AS ENUM ('Text', 'TextArea', 'Select','Radio','Checkbox');
create table tbl_form_option(
    option_id serial primary key not null,
    form_id INTEGER not null,
    field_id INTEGER not null,
    f_type  f_type,
    is_required boolean default false,
    display_order INTEGER not null,
	f_value text not null
    )

