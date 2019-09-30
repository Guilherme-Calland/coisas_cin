import Data.List
import Data.Maybe

-- tipos algebricos

data Figura = Circulo Float
                | Retangulo Float Float

area :: Figura -> Float
area (Circulo r) =  pi * r * r
area (Retangulo l1 l2) = l1 * l2

ehCircular :: Figura -> Bool
ehCircular (Circulo _) = True
ehCircular _ = False

data Lista = Cons Int Lista 
            | Nil 
            deriving (Show)

somaLista :: Lista -> Int
somaLista Nil = 0
somaLista (Cons n l) = n + somaLista l
-- ?

data Arvore = NilT | No Int Arvore Arvore deriving (Show)

somaArvore :: Arvore -> Int
somaArvore NilT = 0
somaArvore (No n arvE arvD) = n 
                            + somaArvore arvE
                            + somaArvore arvD

maxi :: Int -> Int -> Int
maxi x y 
    | x > y = x
    | otherwise = y

profundidadeArv :: Arvore -> Int
profundidadeArv NilT = 0
profundidadeArv (No _ arvE arvD) = 1 + maxi 
                        (profundidadeArv arvE) 
                        (profundidadeArv arvD)

-- collapse :: Arvore -> [Int]
-- collapse NilT = []
-- collapse (No val ArvE ArvD) = collapse ArvE 
--                             ++ [val] 
--                             ++ collapse ArvD

-- tipos polimorficos

data ListaPoli t = NilAT 
                | ConsT t (ListaPoli t) deriving (Show)

-- membroLista :: (Eq t) => t -> [t] -> t -> Bool
-- membroLista val [] = False
-- membroLista val (x:xs) = (x == val) || membroLista val xs

data DiasSemana = Seg | Ter | Qua | Qui | Sex 
                deriving (Show, Eq, Ord, Enum)

data Curso = Manha String | Tarde String deriving (Eq)

instance Eq Curso where
    (Manha n1) == (Manha q1) = n1 == q1
    (Tarde n2) == (Tarde q2) = n2 == q2
    _ == _ = False

class Visivel t where
    toString :: t -> String
    size :: t -> Int

instance Visivel Bool where
    toString True = "True "
    toString False = "False "
    size _ = 1

instance Visivel Curso where
    toString (Manha n) = "Curso " ++ n ++ " da manha."
    toString (Tarde n) = "Curso " ++ n ++ " da tarde."

instance Show Curso where
    show (Manha n) = "Curso pela manha " ++ n
    show (Tarde n) = "Curso pela tarde " ++ n

-- só nao esta compilando.


    






