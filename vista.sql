-- dentro del contenedor o con psql
psql -U postgres -d incidents -c "
CREATE OR REPLACE VIEW vw_incidents AS
SELECT
  uid,
  nces_school_id,
  school_name,
  nces_district_id,
  district_name,
  date,                -- texto original (ej. 4/20/1999)
  school_year,
  NULLIF(year,'')::INT AS year,
  time,
  day_of_week,
  city,
  state,
  school_type,
  NULLIF(REPLACE(enrollment,',',''),'')::INT AS enrollment,
  NULLIF(killed,'')::INT AS killed,
  NULLIF(injured,'')::INT AS injured,
  NULLIF(casualties,'')::INT AS casualties,
  shooting_type,
  NULLIF(age_shooter1,'')::INT AS age_shooter1,
  gender_shooter1,
  race_ethnicity_shooter1,
  shooter_relationship1,
  CASE WHEN shooter_deceased1 IN ('1','true','TRUE','yes','YES') THEN true
       WHEN shooter_deceased1 IN ('0','false','FALSE','no','NO') THEN false
       ELSE NULL END AS shooter_deceased1,
  deceased_notes1,
  NULLIF(age_shooter2,'')::INT AS age_shooter2,
  gender_shooter2,
  race_ethnicity_shooter2,
  shooter_relationship2,
  CASE WHEN shooter_deceased2 IN ('1','true','TRUE','yes','YES') THEN true
       WHEN shooter_deceased2 IN ('0','false','FALSE','no','NO') THEN false
       ELSE NULL END AS shooter_deceased2,
  deceased_notes2,
  NULLIF(REPLACE(white,',',''),'')::INT  AS white,
  NULLIF(REPLACE(black,',',''),'')::INT  AS black,
  NULLIF(REPLACE(hispanic,',',''),'')::INT AS hispanic,
  NULLIF(REPLACE(asian,',',''),'')::INT  AS asian,
  NULLIF(REPLACE(american_indian_alaska_native,',',''),'')::INT AS american_indian_alaska_native,
  NULLIF(REPLACE(hawaiian_native_pacific_islander,',',''),'')::INT AS hawaiian_native_pacific_islander,
  NULLIF(REPLACE(two_or_more,',',''),'')::INT AS two_or_more,
  CASE WHEN resource_officer IN ('1','true','TRUE','yes','YES') THEN true
       WHEN resource_officer IN ('0','false','FALSE','no','NO') THEN false
       ELSE NULL END AS resource_officer,
  weapon,
  weapon_source,
  NULLIF(lat,'')::DOUBLE PRECISION AS lat,
  NULLIF(long,'')::DOUBLE PRECISION AS long,
  NULLIF(REPLACE(staffing,',',''),'')::NUMERIC(10,2) AS staffing,
  low_grade,
  high_grade,
  lunch,
  county,
  state_fips,
  county_fips,
  ulocale
FROM incidents;
"
