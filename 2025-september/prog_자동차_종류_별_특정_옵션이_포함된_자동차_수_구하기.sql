select car_type, count(*) as 'CARS'
from car_rental_company_car
WHERE
  (
    (options LIKE '%가죽시트%') +
    (options LIKE '%열선시트%') +
    (options LIKE '%통풍시트%')
  ) >= 1
group by car_type
order by car_type;