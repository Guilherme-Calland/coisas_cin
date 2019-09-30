type Nome = String
type Idade = Int
type CPF = Int

type Pessoa = (Nome, Idade, CPF)

nome :: Pessoa -> String
nome (nome, idade, cpf) = nome

idade :: Pessoa -> Int
idade (nome, idade, cpf) = idade

pessoa1 = ("pedro", 20, 0911111)

-- listas

-- no gch:
-- 1:[2,3,4]
-- 1:2:[]
-- (1: (2: (3: [])))

double :: [Int] -> [Int]
double [] = []
double (x:xs) = x * 2 : double xs

member :: [Int] -> Int -> Bool
member [] num = False
member (x:xs) num
    | x == num = True
    | otherwise = member xs num

digits :: String -> String
digits [] = []
digits (x:xs)
    | x <= '9' && x >= '0' = x : digits xs
    | otherwise = digits xs

sumPairs :: [(Int, Int)] -> [Int]
sumPairs [] = []
sumPairs ((x,y):xs) = x+y : sumPairs xs






