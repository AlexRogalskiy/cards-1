TRUNCATE TABLE cards.game_players CASCADE;
TRUNCATE TABLE cards.player_cards CASCADE;
TRUNCATE TABLE cards.game CASCADE;
TRUNCATE TABLE  cards.player CASCADE;

ALTER SEQUENCE cards.seq_game RESTART;
ALTER SEQUENCE cards.seq_player RESTART;