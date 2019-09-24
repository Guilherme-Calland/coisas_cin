--funcoes como valores
 
(.) :: (u -> v) -> (t -> u) -> (t -> v)
(.) f g x = f (g x) == 