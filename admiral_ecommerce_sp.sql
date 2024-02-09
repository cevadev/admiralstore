use admiralecommerce;
delimiter $$
CREATE PROCEDURE sp_listarCategoriaSuperior()
BEGIN
-- buscamos aquellas categorias que tenga el campo category_id igual a category_super
-- si la condicion where se cumple, la categoria es superior y no depende de otra categoria
	SELECT category_id, name FROM categories WHERE category_id=category_super AND visible=TRUE;
END$$
CALL sp_listarCategoriaSuperior();

delimiter $$
CREATE PROCEDURE sp_listarCategorias(p_csuper int)
BEGIN
-- buscamos aquellas categorias que tenga el campo category_id distint a category_super
-- si la condicion WHERE se cumple, dicha categoria es dependiente de una supeior.
	SELECT category_id, name FROM categories WHERE category_id<>category_super AND visible=TRUE AND category_super=p_csuper;
END$$
CALL sp_listarCategorias(1);
