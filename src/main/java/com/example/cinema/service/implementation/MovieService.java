package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateMovieRequest;
import com.example.cinema.dto.request.GetAllMoviesByGenreTypeRequest;
import com.example.cinema.dto.response.MovieResponse;
import com.example.cinema.entity.Movie;
import com.example.cinema.repository.IMovieRepository;
import com.example.cinema.service.IMovieService;
import com.example.cinema.util.emums.GenreType;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    DozerBeanMapper mapper = new DozerBeanMapper();

    private final IMovieRepository _movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        _movieRepository = movieRepository;
    }

    @Override
    public MovieResponse createMovie(CreateMovieRequest request) throws Exception {
        if(_movieRepository.findOneByNameAndDeleted(request.getName(), false) != null){
            throw new Exception();
        }
        Movie movie = mapper.map(request, Movie.class);
        movie.setDeleted(false);
        Movie savedMovie = _movieRepository.save(movie);
        return mapMovieToMovieResponse(savedMovie);
    }

    @Override
    public MovieResponse updateMovie(CreateMovieRequest request) throws Exception {
        Movie movie = _movieRepository.findOneByNameAndDeleted(request.getName(), false);
        movie.setDescription(request.getDescription());
        _movieRepository.save(movie);
        return mapMovieToMovieResponse(movie);
    }

    @Override
    public Set<MovieResponse> getAllMovies() throws Exception {
        Set<Movie> movies = _movieRepository.findAllByDeleted(false);
        return movies.stream()
                .map(movie -> mapMovieToMovieResponse(movie))
                .collect(Collectors.toSet());
    }

    @Override
    public MovieResponse getMovie(UUID id) throws Exception {
        Movie movie = _movieRepository.findOneById(id);
        return mapMovieToMovieResponse(movie);
    }

    @Override
    public Set<MovieResponse> getAllMoviesByGenreType(GetAllMoviesByGenreTypeRequest request) throws Exception {
        Set<Movie> movies = _movieRepository.findAllByGenreTypeAndDeleted(request.getGenreType(), false);
        return movies.stream()
                .map(movie -> mapMovieToMovieResponse(movie))
                .collect(Collectors.toSet());
    }

    @Override
    public MovieResponse deleteMovie(UUID id) throws Exception {
        Movie movie = _movieRepository.findOneById(id);
        movie.setDeleted(true);
        _movieRepository.save(movie);
        return mapMovieToMovieResponse(movie);
    }

    private MovieResponse mapMovieToMovieResponse(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setGenreType(movie.getGenreType().toString());
        movieResponse.setName(movie.getName());
        return movieResponse;
    }
}
