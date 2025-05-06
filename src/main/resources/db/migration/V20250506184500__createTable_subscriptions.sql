CREATE TABLE IF NOT EXISTS subscriptions
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT       NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    service_name VARCHAR(255) NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE subscriptions IS 'User subscriptions to digital services';
COMMENT ON COLUMN subscriptions.id IS 'Primary key (subscription ID)';
COMMENT ON COLUMN subscriptions.user_id IS 'Foreign key to users table';
COMMENT ON COLUMN subscriptions.service_name IS 'Name of the subscribed service';
COMMENT ON COLUMN subscriptions.created_at IS 'Timestamp when the subscription was created';