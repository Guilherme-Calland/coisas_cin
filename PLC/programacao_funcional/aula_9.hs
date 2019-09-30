-- tipos 

data Lista = Nil | Cons Int Lista deriving (Show)

somaLista :: Lista -> Int
somaLista Nil = 0
somaLista (COns n l) = n + somaLista l

data Arvore = NilT | No Int Arvore Arvore deriving (Show)

somaArvore :: Arvore -> Int
somaArvore NilT = 0
somaArvore (No val arvE arvD) = val 
                                + somaArvore arvE 
                                + somaArvore arvD

--no ghci: somaArvore (No 3 (No 2 Nilt Nilt) (No 5 Nilt Nilt))

maxi :: Int -> Int
maxi x y
    | x >= y = x
    | otherwise = y

profundidade :: Arvore -> Int
profundidade Nilt = 0
profundidade (No _ ae ad) = 1 + maxi (profundidade ae) (profundidade ad)

collapse :: Arvore -> [Int]
collapse Nilt = []
collapse (No val ae ad) = collapse ae ++ [val] ++ colapse ad

-- tipos polimorficos

data ListaPoli t = NilAT | ConsT t Int (ListaPoli t) deriving (Show)  -- AT -> arvore T

-- (ConsT True (ConsT False NilAT))

-- classes ?

data ListaPoli t = NilAT | ConsT t (ListaPoli t) deriving (Show)

{-
(+) :: Num a => a -> a -> a -> a
-}


membroLista :: (Eq t) => [t] -> t -> Bool
membroLista [] b = False
membroLista (a:as) b = (a==b) || membroLista as b

data DiasSemana = Seg | Ter | Qua | Qui | Sex deriving (Show, Eq, Ord, Enum)
data Curso = Manha String | Tarde String

instance Eq Curso where
    (Manha n1) == (Manha q1) = n1 == q1
    (Tarde n2) == (Tarde q2) = n2 == q2
    _ == _ = False

class Visivel t where
    toString :: t -> String
    size    :: t -> Int

--(Manha "asd") == (Manha "asd")

-- Ter > Seg

instance Visivel Bool where
    toString True = "True"
    toString False = "False"
    size _ = 1

-- Size True

instance Visivel Curso where
    toString (Manha n) = "Curso" ++ n ++ " da manha"
    toString (Tarde n) = "Curso" ++ n ++ " da tarde"
    size _ = 1
    
instance Show Curso where
    show (Manha n) = "Manha " ++ n
    show (Tarde n) = "Manha " ++ n

instance Visicel a => Visivel [a] where
    toString = concat . (map toString)
    size =  (map size)

-- ele vai disponibilizar o codigo dessa aula