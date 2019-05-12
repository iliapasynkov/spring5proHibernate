INSERT INTO SINGER (first_name, last_name, birth_date) VALUES ('John', 'Mayer', '1977-10-16');
INSERT INTO SINGER (first_name, last_name, birth_date) VALUES ('Eric', 'Clapton', '1945-03-30');
INSERT INTO SINGER (first_name, last_name, birth_date) VALUES ('John', 'Butler', '1975-04-01');

INSERT INTO ALBUM (singer_id, title, release_date) VALUES (1, 'The Search For Everything', '2017-01-20');
INSERT INTO ALBUM (singer_id, title, release_date) VALUES (1, 'Battle Studies', '2009-11-17');
INSERT INTO ALBUM (singer_id, title, release_date) VALUES (2, 'From The Craddle', '1994-09-13');

INSERT INTO INSTRUMENT (instrument_id) VALUES ('Drums');
INSERT INTO INSTRUMENT (instrument_id) VALUES ('Guitar');
INSERT INTO INSTRUMENT (instrument_id) VALUES ('Piano');
INSERT INTO INSTRUMENT (instrument_id) VALUES ('Synthesizer');
INSERT INTO INSTRUMENT (instrument_id) VALUES ('Voice');

INSERT INTO SINGER_INSTRUMENT (singer_id, instrument_id) VALUES (1, 'Guitar');
INSERT INTO SINGER_INSTRUMENT (singer_id, instrument_id) VALUES (1, 'Piano');
INSERT INTO SINGER_INSTRUMENT (singer_id, instrument_id) VALUES (2, 'Guitar');
