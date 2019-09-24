
somaListaPares :: [(Int, Int)] -> [Int]
somaListaPares [] = []

--somaListaPares (x:xs) = (fst x + snd x) : somaListaPares xs
somaListaPares ((a,b):xs) = (a + b) : somaListaPares xs


reverterListaInt :: [Int] -> [Int]
reverterListaInt [] = []
reverterListaInt (x:xs) = reverterListaInt xs ++ [x]

repeticao :: Int -> Char -> [Char]
repeticao 0 ch = []
repeticao n ch = ch : repeticao (n-1) ch

-- Ordenacao

iSort :: [Int] -> [Int]
iSort [] = []
iSort (a:as) = ins a (iSort as)

ins :: Int -> [Int] -> [Int]
ins x [] = [x]
ins x (y:ys)
 | x <= y = x:(y:ys)
 | otherwise = y : ins x ys

head1 :: [a] -> a
head1 [] = error "Lista vazia"
head1 (x:_) = x

head2 :: [a] -> a
head2 xs = case xs of
    [] -> error "Lista Vazia"
    (x:_) -> x
    
myLength :: [a] -> Int
myLength [] = 0
myLength (x:xs) = 1 + myLength xs

maiorLista :: [Int] -> Int
maiorLista [] = minBound :: Int
maiorLista [x] = x
maiorLista (x:xs)
 | x > maiorLista xs = x
 | otherwise = maiorLista xs

myReverse :: [a] -> [a]
myReverse [] = []
myReverse (x:xs) = myReverse xs ++ [x]


digits :: String -> String
digits [] = []
digits (x:xs)
 | x <= '9' && x >= '0' = x : digits xs
 | otherwise = digits xs

getClass n = case n of
    5 -> "numero 5"
    6 -> "numero 6"
    _ -> "meh"

getNome n = case n of
    "g" -> "guilermo"
    _ -> "meh"


getNumber :: Int -> String
getNumber n = case n of
    1 -> "one"
    2 -> "two"
    3 -> "three"
    _ -> "go fuck yourself"
    
len :: [Int] -> Int
len [] = 0
len (x:xs) = 1 + len xs

tamLista :: [Int] -> Int
tamLista [] = 0
tamLista (x:xs) = 1 + tamLista xs

(+*) :: [a] -> [a] -> [a]
[] +* y = y
(x:xs) +* y = x : (xs +* y)    

concatenar :: [a] -> [a] -> [a]
concatenar a b = a ++ b

zipa :: [a] -> [b] -> [(a,b)]
zipa (a:as) (b:bs) = (a,b) : zipa as bs 
zipa _ _ = []

reverter0 :: [a] -> [a]
reverter0 [] = []
reverter0 (x:xs) = (reverter0 xs) ++ [x]

replicar :: Int -> a -> [a]
replicar 0 cha = []
replicar n cha = cha : replicar (n-1) cha

takeN :: Int -> [Int] -> [Int]
takeN 0 list = []
takeN n (x:xs) = x : takeN (n-1) xs 

dropN :: Int -> [Int] -> [Int]
dropN 0 list = list
dropN n (x:xs) = dropN (n-1) xs

takWhile :: Int -> [Int] -> [Int]
takWhile a [] = []
takWhile a (x:xs)
 | x > a = x : takWhile a xs
 | otherwise = takWhile a xs

drpWhile :: Int -> [Int] -> [Int]
drpWhile a [] = []
drpWhile a (x:xs)
 | x > a = drpWhile a xs
 | otherwise = x : drpWhile a xs
 

type Name = String
type Age = Int
type Person = [(Name, Age)]

name0 = "jao"
age0 = 20

name1 = "predo"
age1 = 25

makePerson :: Name -> Age -> Person
makePerson name age = [(name, age)]

person0 = makePerson name0 age0
person1 = makePerson name1 age1
person2 = makePerson "tchago" 50
 
type Pessoa = String
type Livro = String
type BancoDados = [(Pessoa, Livro)]

doubleList list = [2*a| a <- list]                

doubleifEven list = [2*a | a<-list, (a `mod` 2) == 0]
      
sumPairs :: [(Int, Int)] -> [Int]
sumPairs list = [a+b| (a, b)  <- list]

digits2 :: String -> String
digits2 str = [num | num <- str , num >= '0' && num <= '9']

--exercicio

