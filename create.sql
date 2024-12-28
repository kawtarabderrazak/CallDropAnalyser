
    create table appel (
        duration integer,
        interrupted bit,
        signal_strength integer,
        call_end datetime(6),
        call_start datetime(6),
        id bigint not null auto_increment,
        zone_id bigint,
        caller varchar(255),
        receiver varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table call_drop_stats (
        call_dropped bit not null,
        latitude float(53) not null,
        longitude float(53) not null,
        id bigint not null auto_increment,
        timestamp datetime(6) not null,
        caller varchar(255),
        zone varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table operateur (
        id bigint not null auto_increment,
        email varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table rapport (
        created_by bigint,
        date_created datetime(6),
        id bigint not null auto_increment,
        content varchar(255),
        title varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table zone (
        latitude float(53),
        longitude float(53),
        id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table appel 
       add constraint FKf4motk6r6hb0xp7pvoqg0sqkh 
       foreign key (zone_id) 
       references zone (id);

    alter table rapport 
       add constraint FKh6ate0sdbdqemtg3809vphv1l 
       foreign key (created_by) 
       references operateur (id);
