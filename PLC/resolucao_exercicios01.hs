sublistas :: [a] -> [[a]]
sublistas [] = [[]]
sublistas (x:xs) = [ x : ys | ys <- sublistas xs] ++ sublistas xs

--aprender a derivar funcoes (questao 1)

-- (a)
poli :: Int -> Int -> Int -> Int -> Int
poli a b c =  (\x -> a * x * x + b * x + c)

-- (b)
listaPoli :: [(Int, Int, Int)] -> [Int -> Int]
listaPoli l = [poli a b c | (a, b, c) <- l]

--outra forma
listaPoli2 [] = []
listaPoli2 ((a,b,c):xs) = poli a b c : listaPoli2 xs

--(poli 2 3 4) 2 
--2 é o x do \x

appListaPoli :: [Int -> Int] -> [Int] -> [Int]
-- appListaPli lFuncoes lInt = [f x | f <- lFuncoes, x <- lInt ]
appListaPoli [] _ = []
appListaPoli (f:fs) (a:as) = f a: appListaPoli fs as
--appListaPoli (listaPoli [(2,3,4),(3,4,5)]) [6,7]


type Codigo = Int
data Candidato = Presidente Codigo | Senador Codigo | Deputado Codigo
                | Branco deriving (Show, Eq)

type Urna = [Candidato]
type Apuracao = [(Candidato, Int)]

urna = [(Presidente 5000), (Presidente 5001), (Senador 100), (Senador 1001), (Deputado 50000), (Deputado 50001), (Deputado 50001), (Deputado 50001)]

totalVotos :: Urna -> Candidato -> Int
totalVotos u c = length (filter (\x -> x == c) u)

--totalVotos urna (Deputado 50001)

apurar :: Urna -> Apuracao
apurar [] = []
apurar (c:cs) = (c, totalVotos  (c:cs) c) : apurar (filter (\x -> x /= c ) cs)