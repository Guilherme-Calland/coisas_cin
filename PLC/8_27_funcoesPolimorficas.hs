-- funcoes polimorficas

tamLista :: [a] -> Int
tamLista [] = 0
tamLista (x:xs) = 1 + tamLista xs

-- Funcao de alta ordem

soma3Int :: Int -> (Int -> (Int -> Int))
soma3Int x y z = x + y + z

aplicaDuasVezes :: (t -> t) -> t -> t
aplicaDuasVezes f x = f (f x)

vendas 0 = 1
vendas 1 = 5
vendas 2 = 4

totalVendas :: Int -> Int
totalVendas 0 = vendas 0
totalVendas n = vendas n + totalVendas (n-1)

total :: (Int -> Int) -> Int -> Int
total f 0 = f 0
total f n = f n + total f (n-1)

totalVendas2 n = total vendas n

quadrado :: Int -> Int
quadrado x = x * x

somaQuadrado n = total quadrado n

--

dobrarValoresLista :: [Int] -> [Int]
dobrarValoresLista [] = []
dobrarValoresLista (x:xs) = x*2 : dobrarValoresLista xs

quadradoValoresLista :: [Int] -> [Int]
quadradoValoresLista [] = []
quadradoValoresLista (x:xs) = x*x : quadradoValoresLista xs

mapeamento :: (Int -> Int) -> [Int] -> [Int]
mapeamento f [] = []
mapeamento f (x:xs) = f x : mapeamento f xs 

dobrar :: Int -> Int
dobrar x = x + x

quadradar :: Int -> Int
quadradar x = x * x

ehPar :: Int -> Bool
ehPar x = mod x 2 == 0

mapEhPar :: (a -> b) -> [a] -> [b]
mapEhPar f [] = []
mapEhPar f (x:xs) = f x : mapEhPar f xs

somaPar :: (Int, Int) -> Int
somaPar (x,y) = x + y

ehDigito :: Char -> Bool
ehDigito x = (x >= '0') && (x <= '9')

mapCL f l = [f x | x <- l ]

--Filtro
-- No GHCi, filter

filtro :: (a -> Bool) -> [a] -> [a]
filtro f [] = []
filtro f (x:xs)
 | f x = x : filtro f xs
 | otherwise = filtro f xs

filtro2 f l = [x | x <- l, f x]

--

somaL :: [Int] -> Int
somaL [] = 0
somaL (x:xs) = x + somaL xs

produtoL :: [Int] -> Int
produtoL [] = 1
produtoL (x:xs) = x * produtoL xs

orL :: [Bool] -> Bool
orL [] = False
orL (x:xs) = x || orL xs

andL :: [Bool] -> Bool
andL [] = False
andL (x:xs) = x && andL xs

mfoldr :: (t -> t -> t) -> t -> [t] -> t
mfoldr f v [] = v
mfoldr f v (x:xs) = f x (mfoldr f v xs)

mfoldl :: (t -> t -> t) -> t -> [t] -> t
mfoldl f v [] = v
mfoldl f v (x:xs) = mfoldl f (f v x) xs

somaDois :: Int -> Int -> Int
somaDois x y = x + y

myOr :: Bool -> Bool -> Bool
myOr False False = False
myOr _ _ = True

{-
mfoldr somaDois 1 [2,3,4]
mfoldr myOr True [False, False, False]
-}


