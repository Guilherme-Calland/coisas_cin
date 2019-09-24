f :: Int -> Int -> Int
f a b = a + 10

-- f (4 + 5) (f 4 6)


g :: Int -> Int
g x = x + g x

-- f 10 (g 1)
--20

-- f (g 1) 10
-- >nao compila

troca :: Int -> a -> a -> a
troca n x y
 | n > 0 = x
 | otherwise = y

--troca 1 'a' 'b'
-- a
--troca (-1) 'a' 'b'
-- b
-- troca 1 0 (g 1)
-- 0

h :: Int -> Int -> Int
h x y = x + y

fk :: [Int] -> [Int] -> Int
fk (x:xs) (y:ys) = x + y

{-
fk [1..] [500..]
501
-}

-- zip [1..5] ['a'..]
-- [(1,'a'),(2,'b'),(3,'c'),(4,'d'),(5,'e')]

--resumo de avaliacao preguiçosa : só calculo se preciso

fatorial :: Integer -> Integer
fatorial 0 = 1
fatorial n = n * fatorial(n-1)

{-
fatorial 3
3 * (2 * (1 * 1))
calcula dentro dos parentesis pra fora
-}

tailFat :: Integer -> Integer -> Integer
tailFat 0 x = x
taiFat n x = tailFat (n-1) (n*x)

tan n = tailFat n 1

-- IO

imprime :: String -> IO ()