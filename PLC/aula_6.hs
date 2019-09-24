-- funcoes polimorficas

tamLista :: [a] -> Int
tamLista [] = 0
tamLista (x:xs) = 1 + tamLista xs

-- funcao de alta ordem

soma3Int :: Int -> (Int -> (Int -> Int))
soma3Int x y z = x + y + z

aplicaDuasVezes :: (t -> t) -> t -> t
aplicaDuasVezes f x = f (f x)

inc :: Int -> Int
inc x = x + 1

--no ghci : aplicaDuasVezes inc 5

total :: (Int -> Int) -> Int -> Int
total f 0 = f 0
total f n = f n + total f (n-1)

quadrado :: Int -> Int
quadrado x = x*x

--no ghci -> total quadrado 5

somaQuadrados n = total quadrado n

--

dobrarValoresLista :: [Int] -> [Int]
dobrarValoresLista [] = []
dobrarValoresLista (x:xs) = (2*x) : dobrarValoresLista xs

dobrarValoresLista2 lista = [x*2| x <- lista]

quadradoValoresLista :: [Int] -> [Int]
quadradoValoresLista [] = []
quadradoValoresLista (x:xs) = (2*x) : quadradoValoresLista xs

quadradoValoresLista2 lista = [x*x| x <- lista]

mapeamento :: (Int -> Int) -> [Int] -> [Int]
mapeamento f [] = []
mapeamento f (x:xs) = f x : mapeamento f xs

ePar :: Int -> Bool
ePar x = mod x 2  == 0

mapEPar :: [Int] -> [Bool]
mapEPar [] = []
mapEPar (x:xs) = ePar x : mapEPar xs

mapM0 :: (a -> b) -> [a] -> [b]
mapM0 f [] = []
mapM0 f (x:xs) = f x : mapM0 f xs

eDigito :: Char -> Bool
eDigito ch = ('0' <= ch) && (ch <= '9')

-- ghci -> mapM0 eDigito "ashdjka71829378129as87121371237j"

somaPar :: (Int, Int) -> Int
somaPar (x,y) = x + y

mapCL f l = [f x | x <- l]

-- filtro

filtro :: (a -> Bool) ->  [a] -> [a]
filtro f [] = []
filtro f (x:xs)
 | f x = x : filtro f xs
 | otherwise = filtro f xs

filtroCL f l = [x| x<- l,f x]

somaL :: [Int] -> Int
somaL [] = 0
somaL (x:xs) = (*) x (produtoL xs)

-- produtoL :: [Int] -> Int
-- produtoL [] = 1
-- produtoL (x:xs) = (*) + (produtoL xs)

orL [] = False
orL (x:xs) = (||) x (orL xs)

andL [] = True
andL (x:xs) = (&&) x (andL xs)

mfoldr :: (t -> t -> t) -> t -> [t] -> t
mfoldr f v [] = v
mfoldr f v (x:xs) = f x (mfoldr f v xs)

{-
mfold (||) False [True, False]
= (||) True (mfoldr (||) False [False])
= (||) True ((||) False (mfoldr (||) False []))
= (||) True ((||) False False)
-}

-- aula de hoje é o slide 05_funcoesValores

mfoldl :: (t -> t -> t) -> t -> [t] -> t
mfoldl f v [] = v
mfoldl f v (x:xs) = mfoldl f (f v x) xs

inc3 :: Int -> Int
inc3 x = (iter 3 inc) x

incN :: Int -> Int -> Int
incN n x = (iter n inc) x

addNum :: Int -> (Int -> Int)
addNum n = h
    where
        h x = n + x

-- quantos argumentos uma funcao tem? --parou mais ou menos aqui


