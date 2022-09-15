

INSERT INTO products
(
    id,
    name,
    description
)
VALUES
(
    concat(to_char(now(), 'yy'), LPAD(EXTRACT('doy' FROM now())::TEXT, 3, '0'), LPAD(nextval('product_seq')::TEXT, 7, '0')),
    'iphone12',
    'IOS product'
),
(
    concat(to_char(now(), 'yy'), LPAD(EXTRACT('doy' FROM now())::TEXT, 3, '0'), LPAD(nextval('product_seq')::TEXT, 7, '0')),
    'iphone13',
    'IOS product'
),
(
    concat(to_char(now(), 'yy'), LPAD(EXTRACT('doy' FROM now())::TEXT, 3, '0'), LPAD(nextval('product_seq')::TEXT, 7, '0')),
    'iphone14',
    'IOS product'
),
(
    concat(to_char(now(), 'yy'), LPAD(EXTRACT('doy' FROM now())::TEXT, 3, '0'), LPAD(nextval('product_seq')::TEXT, 7, '0')),
    'SumsungGALAXY',
    'Android'
);

INSERT INTO categories
(
    id,
    name
)
VALUES
(
    concat(to_char(now(), 'yy'), LPAD(EXTRACT('doy' FROM now())::TEXT, 3, '0'), LPAD(nextval('categories_seq')::TEXT, 7, '0')),
    'Android'
),
(
    concat(to_char(now(), 'yy'), LPAD(EXTRACT('doy' FROM now())::TEXT, 3, '0'), LPAD(nextval('categories_seq')::TEXT, 7, '0')),
    'IOS'
);
INSERT INTO product_has_category
(
    product_id,
    category_id
)
VALUES
(
    (SELECT id FROM products WHERE "name" = 'iphone12'),
    (SELECT id FROM categories WHERE "name" = 'IOS')
),
(
    (SELECT id FROM products WHERE "name" = 'SumsungGALAXY'),
    (SELECT id FROM categories WHERE "name" = 'Android')
);