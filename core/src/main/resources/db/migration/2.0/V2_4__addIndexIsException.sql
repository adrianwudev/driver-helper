CREATE INDEX idx_orders_weekday_isException ON public.orders (weekday, is_exception);
CREATE INDEX idx_orders_isException ON public.orders (is_exception);
