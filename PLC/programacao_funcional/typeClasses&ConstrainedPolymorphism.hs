-- type classes & Constrained Polymorphism


-- acho que pra ser da classe Eq tem que ser de um tipo
-- que isso faça sentido (a1 == a2) = True dado que a1, a2 sao
-- de um tipo que pertene à classe Eq 


-- typeclass
class Eq a where
    (==) :: a -> a -> Bool
    
-- instance of a typeclass
-- instance Eq Person where
--     p1 == p2 = ...
    
-- meuElem :: (Eq a) => a -> [a] -> Bool
-- meuElem val [] = False
-- meuElem val (x:xs) = (( x == val ) || meuElem val xs)

--entao, typeclasses criam uma restricao ao polimorfismo
--aonde (Eq a) => a nos diz que pode-se usar qualquer tipo a
-- desde que a seja membro do typeclass Eq.
-- em outras palavras, se demonstramos como esse tipo de
-- operador (Eq) funciona para esse tipo (Int por exemplo),
-- entao ele é mebro da typeclass. Perceba agora que se 
-- mostrarmos como Person é membro de Eq ele tambem 
-- virará membro dessa typeclass




