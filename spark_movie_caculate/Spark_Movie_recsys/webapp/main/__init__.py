from flask import Blueprint

main = Blueprint('main', __name__)

from . import users, movies, recommend
import webapp
#from .. import recommendation_engine

