use admiralecommerce;
delimiter $$
DROP PROCEDURE sp_listarCategoriaSuperior $$
CREATE PROCEDURE sp_listarCategoriaSuperior()
BEGIN
-- buscamos aquellas categorias que tenga el campo category_id igual a category_super
-- si la condicion where se cumple, la categoria es superior y no depende de otra categoria
	SELECT category_id, name FROM categories WHERE category_id=category_super AND visible=TRUE;
END$$
CALL sp_listarCategoriaSuperior();

use admiralecommerce;
delimiter $$
DROP PROCEDURE sp_listarSubCategorias $$
CREATE PROCEDURE sp_listarSubCategorias(p_csuper int)
BEGIN
-- buscamos aquellas categorias que tenga el campo category_id distint a category_super
-- si la condicion WHERE se cumple, dicha categoria es dependiente de una supeior.
	SELECT category_id, name FROM categories WHERE category_id<>category_super AND visible=TRUE AND category_super=p_csuper;
END$$
CALL sp_listarSubCategorias(7);

USE admiralecommerce;
delimiter $$
CREATE PROCEDURE sp_contarSubCategorias(categoryId int)
BEGIN
	SELECT COUNT(*) as quantity FROM categories WHERE category_super = categoryId AND category_id<>categoryId;
END$$
CALL sp_contarSubCategorias(1);
