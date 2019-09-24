-- tipos algebricos

data Temperatura = Quente | Frio deriving (Show)
data Estacao = Verao | Outono | Inverno | Primavera
data DiasSemana = Seg | Ter | Qua | Qui | Sex

clima :: Estacao -> Temperatura
clima Inverno = Frio
clima _ = Quente

data Pessoa = Nome String

nome :: Pessoa -> String
nome (Nome n) = n 

{-
nome (Nome "jao")
-}

type Nome = String
type Idade = Int
type Ano = Int
data Pessoas = Pessoa Nome Idade
data Livros = Livro Nome Ano

showPessoa :: Pessoas -> String
showPessoa (Pessoa n i) = n ++ " -- " ++ show i --transforma int em String

-- showPessoa (Pessoa "jao" 30)

data Figura = 
     Circulo Float
   | Retangulo Float Float
   | Triangulo Float Float Float

area :: Figura  -> Float
area (Circulo r) = 3.14*r*r
area (Retangulo a b) = a * b

circular :: Figura -> Bool
circular (Circulo _) = True
circular _ = False

data Expr = Lit Int
            | Add Expr Expr
            | Sub Expr Expr

eval :: Expr -> Int
eval (Lit n) = n
eval (Add e1 e2) = eval e1 + eval e2
eval (Sub e1 e2) = eval e1 - eval e2

-- eval (Add (Lit 2) (Lit 3))
-- eval (Add (Add (Lit 2) (Lit 3)) (Sub (Lit 6) (Lit 4)))

exibirExpr :: Expr -> String
exibirExpr (Lit n) = show n
exibirExpr (Add e1 e2) = exibirExpr e1 ++
                        " + " ++
                        exibirExpr e2
exibirExpr (Sub e1 e2) = exibirExpr e1 ++
                        " - " ++
                        exibirExpr e2