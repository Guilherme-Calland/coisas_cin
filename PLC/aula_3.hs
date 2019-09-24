-- definicoes locais

quadrado :: Int -> Int 
quadrado n = n*n

somaQuadrados :: Int -> Int -> Int
somaQuadrados a b = quadrado a + quadrado b

sumSquares :: Int -> Int -> Int
sumSquares a b = quadA + quadB
    where
        quadA = a*a
        quadB = b*b

sumSquares2 :: Int -> Int -> Int
sumSquares2 a b = quad a + quad b
        where
            quad n = n*n

sumSquares3 :: Int -> Int -> Int
sumSquares3 a b = let quad n = n*n
            in quad a + quad b

-- data.char
offset :: Int
offset = fromEnum 'A' - fromEnum 'a'

toUpper :: Char -> Char
toUpper ch = toEnum (fromEnum ch + offset)

isDigit :: Char -> Bool
isDigit ch = (ch >= '0') && (ch <= '9')

--estrutura de dados : Tupla

addDupla :: (Int, Int) -> Int
addDupla (x,y) = x + y

primeiro :: (Int, Int) -> Int
primeiro (a,b) = a

segundo :: (x, y) -> y
segundo (a,b) = b

shift :: (a, (b, c)) -> ((a, b), c)
shift (x, (y, z)) = ((x, y), z)

addSpaces :: Int -> String
addSpaces n
            | n == 1 = " "
            | otherwise = " " ++ addSpaces(n-1)

paraDireita :: Int -> String -> String
paraDireita n str
            | n == 1 = " " ++ str
            | otherwise = addSpaces(n) ++ str

menorMaior :: Int -> Int -> Int -> (Int, Int)
menorMaior a b c = (men, mai)
            where 
                men = menor a b c
                mai = maior a b c
                menor a b c
                    | a < b && a < c = a
                    | b < a && b < c = b
                    | otherwise = c
                maior a b c
                    | a > b && a > c = a
                    | b > a && b > c = b
                    | otherwise = c

ordenaTripla :: (Int, Int, Int) -> (Int, Int, Int)
ordenaTripla (a, b, c) = (x, y, z)
    where
        x = n0 a b c
        y = n1 a b c
        z = n2 a b c
        n0 a b c
            | a < b && a < c = a
            | b < a && b < c = b
            | otherwise = c
        n1 a b c
            | (a > b && a < c) || (a > c && a < b) = a
            | (b > a && b < c) || (b > c && b < a) = b
            | otherwise = c
        n2 a b c
            | a > b && a > c = a
            | b > a && b > c = b
            | otherwise = c




                 
                    
            
=======
-- definições locais

--duas formas aonde

quadrado :: Int -> Int
quadrado n = n*n

somaQuadrados :: Int -> Int -> Int
somaQuadrados x y = quadrado x + quadrado y

--forma sebosa de fazer
sumSquares :: Int -> Int -> Int
sumSquares x y = quadX+quadY
    where
        quadX = x*x 
        quadY = y*y

sumSquares2 :: Int -> Int -> Int
sumSquares2 x y = quad x + quad y
        where
            quad n = n * n

--let x = 2 * 4 in x + 6
--(let x = 2 in x + 6) < 10

sumSquares3 :: Int -> Int -> Int
sumSquares3 x y = let quadX = x*x
                      quadY = y*y
                  in quadX + quadY

-----------------------------------------

vendas 1 = 4
vendas 2 = 5
vendas 3 = 7

vendasNulas :: Int -> Bool
vendasNulas 0 = (vendas 0 == 0)
vendasNulas n = (vendas n == 0) || vendasNulas (n - 1)
