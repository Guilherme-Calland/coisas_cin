

--2
sublistas :: [Int] -> [[Int]]
sublistas [] = [[]]
sublistas (x:xs) = [ (x:ys) | ys <- sublistas xs ] ++ sublistas xs
--3
--a
poli :: Int -> Int -> Int -> Int -> Int
poli a b c = (\x->a*x*x + b*x + c)
--b
listaPoli :: [(Int, Int, Int)] -> [Int -> Int]
listaPoli l = [(\x->a*x*x + b*x + c) | (a,b,c) <- l ]
--c
appPoli :: [Int -> Int] -> [Int] -> [Int]
appPoli listaF listaX = [f x | f <- listaF, x <- listaX]

appPoli2 _ [] = []
appPoli2 (f:fs) (x:xs) = f x : appPoli2 fs xs

--4
--a
validarMatriz :: [[Int]] -> Bool
validarMatriz [] = True
validarMatriz [x] = True
validarMatriz (x:y:ys) = length x == length y && validarMatriz ys
--b
permuta :: Int -> Int -> [[Int]] -> [[Int]]
permuta a b m =
    (take (a-1) m) ++ [(m!!(b-1))]
    ++ (drop a (take (b-1) m)) ++ [(m!!(a-1))]
    ++ (drop b m) 
--5

filtrarEInserir :: [[Int]] -> Int -> ([[Int]],Int)
filtrarEInserir l n = (r1, r2)
    where
        r1 = listasCujaSomaImparMaiorQuePar l
        r2 = n * maiorNum (somaListas r1)

listasCujaSomaImparMaiorQuePar :: [[Int]] -> [[Int]]
listasCujaSomaImparMaiorQuePar [] = []
listasCujaSomaImparMaiorQuePar (x:xs)
 | soma (filter ehImpar x) > soma (filter ehPar x) = x : listasCujaSomaImparMaiorQuePar xs
 | otherwise = listasCujaSomaImparMaiorQuePar xs

soma :: [Int] -> Int
soma [] = 0
soma (x:xs) = x + soma xs

ehPar :: Int -> Bool
ehPar x
 | mod x 2 == 0 = True
 | otherwise = False

ehImpar :: Int -> Bool
ehImpar x 
 | ehPar x = False
 | otherwise = True

maiorNum :: [Int] -> Int
maiorNum [x] = x
maiorNum (x:y:ys)
 | x > y = maiorNum (x:ys)
 | otherwise = maiorNum (y:ys)

somaListas :: [[Int]] -> [Int]
somaListas [] = []
somaListas (x:xs) = soma x : somaListas xs
--6
altMap :: (a->b)->(a->b)->[a]->[b]
altMap f g [] = []
altMap f g [x] = [f x]
altMap f g (x:y:xs) = (f x) : (g x) : altMap f g xs


 


